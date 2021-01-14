package com.tajawal.api.steps;

import com.jayway.restassured.response.Response;
import com.tajawal.api.config.Hooks;
import com.tajawal.api.wrapper.WrapperClass;
import com.tajawal.api.calenderFare.request.pojo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the service layer for calender fare step definition
 *
 * @user Sakthy
 */
public class CalenderFareStepService extends WrapperClass {
    Response postResposne = null;
    String fromDate = getFutureDate("1");
    String toDate = getFutureDate("5");

    public void callcalenderFare(String org, String dst, Integer adult) throws Exception {
        postResposne = callRestPostMethod(createClanderFareRequest(org, dst, fromDate
                , toDate,
                "Economy", "1", "0", "0", "", "all"),
                Hooks.applicationProperties.getProperty("flight.calenderFare.post.url"));
    }

    public void verifyStatusCode() {
        Assert.assertEquals("Start Code Verificatio", 200, postResposne.getStatusCode());
    }

    public void verifyResponseKey() {
        HashMap<String, Map<String, Object>> responseObject = postResposne.jsonPath().get();
        long count = responseObject.keySet().stream()
                .filter(a -> (convertStringToLocalDate(a).isAfter(convertStringToLocalDate(fromDate))
                        && convertStringToLocalDate(a).isBefore(convertStringToLocalDate(toDate)))
                        || (convertStringToLocalDate(a).isEqual(convertStringToLocalDate(fromDate))
                        || convertStringToLocalDate(a).isEqual(convertStringToLocalDate(toDate)))).count();
        Assert.assertEquals("Date present in the key are not with in the from and to date",
                count, responseObject.keySet().size());
        responseObject.keySet().stream().forEach(a -> {
            Assert.assertTrue("Price is not present in the resposne", responseObject.get(a).containsKey("price"));
            Assert.assertTrue("Price is not present in the resposne", responseObject.get(a).containsKey("updatedAt"));

        });

    }

    public void callcalenderFare(String org, String dst, String from, String to, String cabin, String adtCount, String chdCount, String infCount, String airline, String type) throws Exception {
        postResposne = callRestPostMethod(createClanderFareRequest(org, dst, getFutureDate(from)
                , getFutureDate(to),
                cabin, adtCount, chdCount, infCount, airline, type),
                Hooks.applicationProperties.getProperty("flight.calenderFare.post.url"));
    }

    public void verfiyErrorResposne() {
        Assert.assertTrue("STATUS CODE VALIDATION FAILED",postResposne.getStatusCode()==400);
    }

    public void verifyResponseCode(){
        Assert.assertTrue("STATUS CODE VALIDATION FAILED",postResposne.getStatusCode()==200);
    }

    public CalenderFareRequest createClanderFareRequest(String origin, String destination, String from, String to, String cabin, String adtCount, String chdCount, String infCount, String airline, String type) throws Exception {
        CalenderFareRequest calenderFareRequest = new CalenderFareRequest();
        boolean status = true;
        Leg leg = new Leg();
        status = StringUtils.isNotBlank(from) ? leg.setDepartureFrom(from) : false;
        status = StringUtils.isNotBlank(to) ? leg.setDepartureTo(to) : false;
        status = StringUtils.isNotBlank(destination) ? leg.setDestinationId(destination) : false;
        status = StringUtils.isNotBlank(origin) ? leg.setOriginId(origin) : false;

        List<Leg> legs = new ArrayList<Leg>();
        legs.add(leg);
        calenderFareRequest.setLeg(legs);
        status = StringUtils.isNotBlank(cabin) ? calenderFareRequest.setCabin(cabin) : false;
        Pax pax = new Pax();
        status = StringUtils.isNotBlank(adtCount) ? pax.setAdult(Integer.parseInt(adtCount)) : false;
        status = StringUtils.isNotBlank(chdCount) ? pax.setChild(Integer.parseInt(chdCount)) : false;
        status = StringUtils.isNotBlank(infCount) ? pax.setInfant(Integer.parseInt(infCount)) : false;
        calenderFareRequest.setPax(pax);
        List<Object> stop = new ArrayList<Object>();

        switch (type) {
            case "noStops":
                calenderFareRequest.setAirline(stop);
                calenderFareRequest.setAirports(new Airports());
                calenderFareRequest.setTimeSlots(new TimeSlots());
                break;
            case "noAirline":
                calenderFareRequest.setStops(stop);
                calenderFareRequest.setAirline(stop);
                calenderFareRequest.setTimeSlots(new TimeSlots());
                break;
            case "noTimeSlot":
                calenderFareRequest.setStops(stop);
                calenderFareRequest.setAirline(stop);
                calenderFareRequest.setAirports(new Airports());
                break;
            case "noAirports":
                calenderFareRequest.setStops(stop);
                calenderFareRequest.setAirports(new Airports());
                calenderFareRequest.setTimeSlots(new TimeSlots());
                break;
            case "noOption":
                break;
            case "all":
                calenderFareRequest.setStops(stop);
                calenderFareRequest.setAirline(stop);
                calenderFareRequest.setAirports(new Airports());
                calenderFareRequest.setTimeSlots(new TimeSlots());
                break;
            case "all-EK":
                stop.add(airline);
                calenderFareRequest.setStops(stop);
                calenderFareRequest.setAirline(new ArrayList<Object>());
                calenderFareRequest.setAirports(new Airports());
                calenderFareRequest.setTimeSlots(new TimeSlots());
                break;
            default:
                break;
        }
//        status=    "noStops".equals(type) ? false : "all".equals(type)
//                ?  calenderFareRequest.setStops(stop) :calenderFareRequest.setStops(stop);
//        calenderFareRequest.setStops(stop);
//        status=    "noAirline".equals(type) ? false : "all".equals(type)
//                ?  calenderFareRequest.setAirline(stop) :false;
////        calenderFareRequest.setAirline(stop);
//        status=    "noAirports".equals(type) ? false : "all".equals(type)
//                ? calenderFareRequest.setAirports(new Airports()) : false;
//        status=    "noTimeSlot".equals(type) ? false : "all".equals(type)
        Hooks.hooksScenario.write("Request: " + new ObjectMapper().writeValueAsString(calenderFareRequest));
        return calenderFareRequest;
    }
}

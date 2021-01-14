package com.tajawal.api.calenderFare.request.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "leg",
        "cabin",
        "pax",
        "stops",
        "airline",
        "timeSlots",
        "airports"
})
public class CalenderFareRequest {

    @JsonProperty("leg")
    private List<Leg> leg = null;
    @JsonProperty("cabin")
    private String cabin;
    @JsonProperty("pax")
    private Pax pax;
    @JsonProperty("stops")
    private List<Object> stops = null;
    @JsonProperty("airline")
    private List<Object> airline = null;
    @JsonProperty("timeSlots")
    private TimeSlots timeSlots;
    @JsonProperty("airports")
    private Airports airports;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("leg")
    public List<Leg> getLeg() {
        return leg;
    }

    @JsonProperty("leg")
    public boolean setLeg(List<Leg> leg) {
        this.leg = leg;
        return true;
    }

    @JsonProperty("cabin")
    public String getCabin() {
        return cabin;
    }

    @JsonProperty("cabin")
    public boolean setCabin(String cabin) {
        this.cabin = cabin;
        return true;
    }

    @JsonProperty("pax")
    public Pax getPax() {
        return pax;
    }

    @JsonProperty("pax")
    public boolean setPax(Pax pax) {
        this.pax = pax;
        return true;
    }

    @JsonProperty("stops")
    public List<Object> getStops() {
        return stops;
    }

    @JsonProperty("stops")
    public boolean setStops(List<Object> stops) {
        this.stops = stops;
        return true;
    }

    @JsonProperty("airline")
    public List<Object> getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public boolean setAirline(List<Object> airline) {
        this.airline = airline;
        return true;
    }

    @JsonProperty("timeSlots")
    public TimeSlots getTimeSlots() {
        return timeSlots;
    }

    @JsonProperty("timeSlots")
    public boolean setTimeSlots(TimeSlots timeSlots) {
        this.timeSlots = timeSlots;
        return true;
    }

    @JsonProperty("airports")
    public Airports getAirports() {
        return airports;
    }

    @JsonProperty("airports")
    public boolean setAirports(Airports airports) {
        this.airports = airports;
        return true;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

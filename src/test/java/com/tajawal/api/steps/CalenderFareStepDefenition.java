package com.tajawal.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalenderFareStepDefenition extends CalenderFareStepService {
    @Given("call the calender fare api with origin {string} destination {string} adult {int}")
    public void call_the_calender_fare_api_with_origin_destination_adult(String org, String dst, Integer adult) throws Exception {
        callcalenderFare(org, dst, adult);
    }

    @Then("verify the status code for calender fare")
    public void verify_the_status_code_for_calender_fare() {
        verifyStatusCode();
    }

    @Then("verify the response key with date range")
    public void verify_the_response_key() {
        verifyResponseKey();
    }


    @Given("call the calendar fare api with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void call_the_calendar_fare_api_with(String org, String dst, String from, String to, String cabin, String adtCount, String chdCount, String infCount, String airline, String type) throws Exception {
        callcalenderFare(org, dst, from, to, cabin, adtCount, chdCount, infCount, airline, type);
    }

    @Then("validate the error response code for mandatory element validation")
    public void validate_the_error_response() {
        verfiyErrorResposne();
    }

    @Then("validate the error response code for optional element validation")
    public void validateTheErrorResponseCodeForOptionalElementValidation() {
        verifyResponseCode();
    }


}

package com.tajawal.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class AutocompleteSetpDefenition extends AutocompleteStepService {


    @Given("call the autocomplete API with {string}")
    public void call_the_autocomplete_API_with(String value) throws IOException {
        callHotelAutoComplete(value);
    }

    @Then("verify the status code")
    public void verify_the_status_code() {
        verifyStatusCode();
    }

    @Then("verify the json structure has locations as List")
    public void verify_the_json_structure_has_locations_as_List() {
        verifyTheResposneHavingLocations();
    }

    @Then("verify the location element of the resposne has all the required key")
    public void verify_the_location_element_of_the_resposne_has_all_the_required_key() {
        verifyTheLocationsElementHavingMandatoryKey();

    }

    @Then("verify the json structure has hotels as List")
    public void verify_the_json_structure_has_hotels_as_List() {
        verifyTheResposneHavingHotels();

    }

    @Then("verify the hotel element of the resposne has all the required key")
    public void verify_the_hotel_element_of_the_resposne_has_all_the_required_key() {
        verifyTheHotelElementHavingMandatoryKey();

    }

    @Given("call the autocomplete API with different {string}")
    public void call_the_autocomplete_API_with_different(String value) throws IOException {
        callHotelAutoComplete(value);

    }

    @Then("verify the size of the locations List as {int}")
    public void verify_the_size_of_the_locations_List_as(Integer int1) {
        verifySizeOfLocationsList();

    }

    @Then("verify the size of the hotel List as {int}")
    public void verify_the_size_of_the_hotel_List_as(Integer int1) {
        verifySizeOfHotelsList();

    }

//    @Given("call the autocomplete API with {string}")
//    public void call_the_autocomplete_API_with_different_character_in_query_parameter(String value) throws IOException {
//        callHotelAutoComplete(value);
//
//    }

    @Then("verify the typeNameAr text is arabic")
    public void verify_the_typeNameAr_text_is_arabic() {
        verifyTheTypeNameArIsArabic();
    }

    @Then("verify the response with actual json schema")
    public void verify_the_response_with_actual_json_schema() {
        verifyAutocompleteResponeWithActualAutocompleteSchema();
    }

    @Then("verify the display type of locations")
    public void verify_the_display_type_of_locations() {
        verifyLocationDisplayType();
    }

    @Then("verify the display type of hotels")
    public void verify_the_display_type_of_hotels() {
        verifyHotelDisplayType();
    }


}

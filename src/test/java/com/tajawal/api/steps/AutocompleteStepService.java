package com.tajawal.api.steps;

import com.jayway.restassured.response.Response;
import com.tajawal.api.config.Hooks;
import com.tajawal.api.utility.AutocompleteResponseConstants;
import com.tajawal.api.wrapper.WrapperClass;
import com.tajawal.api.autocomplete.response.pojo.AutoCompletResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.io.IOException;

/**
 * This is the service layer for the autocomplete step definition
 *
 * @user Sakthy
 */
public class AutocompleteStepService extends WrapperClass {

    Response getResposne = null;
    AutoCompletResponse autoCompletResponse = null;


    public void callHotelAutoComplete(String value) throws IOException {
        getResposne = callRestGetMethod(value, Hooks.applicationProperties.getProperty("hotel.autocomplete.get.url"), Hooks.applicationProperties.getProperty("hotel.autocomplete.token"));
        autoCompletResponse = loadJsonToAutoCompletResponse(getResposne.asString());
    }

    public void verifyStatusCode() {
        Assert.assertEquals("Start Code Verificatio", 200, getResposne.getStatusCode());
    }

    public void verifyTheResposneHavingLocations() {
        Assert.assertTrue("Locations List NOT Present in the Resposne", getResposne.jsonPath().getList(AutocompleteResponseConstants.locationsLst_key).size() <= 5);
    }

    public void verifyTheLocationsElementHavingMandatoryKey() {
        Assert.assertTrue("Name key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_name_key)));
        Assert.assertTrue("City key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_city_key)));
        Assert.assertTrue("Country key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_country_key)));
        Assert.assertTrue("DisplayType key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_displayType_key)));
        Assert.assertTrue("PlaceId key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_placeId_key)));
        Assert.assertTrue("Source key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_source_key)));
        Assert.assertTrue("GoogleType key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_googleType_key)));
        Assert.assertTrue("TypeNameEn key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_googleType_typeNameEn_key)));
        Assert.assertTrue("TypeNameAr key is not present in Location Element", StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_googleType_typeNameAr_key)));
    }

    public void verifyTheResposneHavingHotels() {
        Assert.assertTrue("Hotels List NOT Present in the Resposne", getResposne.jsonPath().getList(AutocompleteResponseConstants.locationsLst_key).size() <= 5);
    }

    public void verifyTheHotelElementHavingMandatoryKey() {
        Assert.assertTrue("Name key is not present in hotel Element",
                StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.hotel_name_key)));
        Assert.assertTrue("City key is not present in hotel Element",
                StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.hotel_city_key)));
        Assert.assertTrue("Country key is not present in hotel Element",
                StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.hotel_country_key)));
        Assert.assertTrue("PlaceId key is not present in hotel Element",
                StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.hotel_thumbnail_url_key)));
        Assert.assertTrue("DisplayType key is not present in hotel Element",
                StringUtils.isNoneEmpty(getResposne.jsonPath().getString(AutocompleteResponseConstants.hotel_displayType_key)));
    }


    public void verifySizeOfLocationsList() {
        Assert.assertTrue("Locations siz is greater than 5", autoCompletResponse.getLocations().size() <= 5);
    }

    public void verifySizeOfHotelsList() {
        Assert.assertTrue("Hotels siz is greater than 5", autoCompletResponse.getHotels().size() <= 5);
    }

    public void verifyTheTypeNameArIsArabic() {
        Assert.assertTrue("The given text is not Arabic",
                verifyTheGiveTextIsArabic(getResposne.jsonPath().getString(AutocompleteResponseConstants.location_googleType_typeNameAr_key)));
    }

    public void verifyAutocompleteResponeWithActualAutocompleteSchema() {
        validateSchemaForGiven(AutocompleteResponseConstants.autocomplete_rsp_schema, getResposne.asString());
    }

    public void verifyLocationDisplayType() {
        autoCompletResponse.getLocations().stream().forEach(a -> {
            Assert.assertTrue("Display Type for Hotel is not equal",
                    AutocompleteResponseConstants.autocomplete_display_type_location_value.equals(a.getDisplayType()));
        });
    }

    public void verifyHotelDisplayType() {
        autoCompletResponse.getHotels().stream().forEach(a -> {
            Assert.assertTrue("Display Type for Hotel is not equal",
                    AutocompleteResponseConstants.autocomplete_display_type_hotel_value.equals(a.getDisplayType()));
        });
    }
}

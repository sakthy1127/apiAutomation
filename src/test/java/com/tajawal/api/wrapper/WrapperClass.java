package com.tajawal.api.wrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.tajawal.api.autocomplete.response.pojo.AutoCompletResponse;
import com.tajawal.api.config.Hooks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class WrapperClass {

    /**
     * This method will be used to call the GET http method with header has token key and uri have the queryParam as query
     *
     * @param value
     * @param url
     * @param header
     * @return
     * @user Sakthy
     */
    public Response callRestGetMethod(String value, String url, String header) {
        Response ds = RestAssured.given()
                .header("token", header)
                .queryParam("query", value)
                .get(url);
        Hooks.hooksScenario.write(ds.asString());
        return ds;
    }

    /**
     * This method will be used to call the POST http method with request object  and url
     * @param request
     * @param url
     * @return
     *
     * @user Sakthy
     */
    public Response callRestPostMethod(Object request, String url) {
        Response ds = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Host", "tajawal.ae")
                .body(request)
                .post(url);
        Hooks.hooksScenario.write("Response: " + ds.asString());
        return ds;
    }

    /**
     * This method will verify whether the give file is arabic or not
     * @param text
     * @return
     * @user Sakthy
     */
    public boolean verifyTheGiveTextIsArabic(String text) {
        return IntStream.range(0, text.length())
                .filter(a -> Character.UnicodeBlock.of(text.codePointAt(a)) == Character.UnicodeBlock.ARABIC).
                        count() == text.length();
    }

    /**
     * This method will validate the given json and corresponding json schema
     * @param schemaValue
     * @param actualJson
     *
     * @user Sakthy
     */
    public void validateSchemaForGiven(String schemaValue, String actualJson) {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(WrapperClass.class.getResourceAsStream(schemaValue)));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(new ByteArrayInputStream(actualJson.getBytes())));
        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }

    /**
     * This method will load the json string to the AutoCompletResponse object
     * @param rspJson
     * @return
     * @throws IOException
     *
     * @user Sakthy
     */
    public AutoCompletResponse loadJsonToAutoCompletResponse(String rspJson) throws IOException {
        ObjectMapper ob = new ObjectMapper();
        return ob.readValue(rspJson, AutoCompletResponse.class);
    }

    /**
     * This method will increse the day from current date to the no of days passed and return the date as string
     * @param noOfDays
     * @return
     *
     * @user Sakthy
     */
    public String getFutureDate(String noOfDays) {
        if (StringUtils.isNotBlank(noOfDays))
            return LocalDate.now().plus(Integer.parseInt(noOfDays), ChronoUnit.DAYS).toString();
        else
            return "";
    }

    /**
     * This method will convert the String to date with for "yyyy-MM-dd"
     * @param date
     * @return
     *
     * @user Sakthy
     */
    public LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }


}

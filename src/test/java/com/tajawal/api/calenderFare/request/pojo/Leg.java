package com.tajawal.api.calenderFare.request.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "originId",
        "destinationId",
        "departureFrom",
        "departureTo"
})
public class Leg {

    @JsonProperty("originId")
    private String originId;
    @JsonProperty("destinationId")
    private String destinationId;
    @JsonProperty("departureFrom")
    private String departureFrom;
    @JsonProperty("departureTo")
    private String departureTo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("originId")
    public String getOriginId() {
        return originId;
    }

    @JsonProperty("originId")
    public boolean setOriginId(String originId) {
        this.originId = originId;
        return true;
    }

    @JsonProperty("destinationId")
    public String getDestinationId() {
        return destinationId;
    }

    @JsonProperty("destinationId")
    public boolean setDestinationId(String destinationId) {
        this.destinationId = destinationId;
        return true;
    }

    @JsonProperty("departureFrom")
    public String getDepartureFrom() {
        return departureFrom;
    }

    @JsonProperty("departureFrom")
    public boolean setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
        return true;
    }

    @JsonProperty("departureTo")
    public String getDepartureTo() {
        return departureTo;
    }

    @JsonProperty("departureTo")
    public boolean setDepartureTo(String departureTo) {
        this.departureTo = departureTo;
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

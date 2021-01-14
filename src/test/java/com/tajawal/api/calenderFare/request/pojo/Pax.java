package com.tajawal.api.calenderFare.request.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "adult",
        "child",
        "infant"
})
public class Pax {

    @JsonProperty("adult")
    private Integer adult;
    @JsonProperty("child")
    private Integer child;
    @JsonProperty("infant")
    private Integer infant;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("adult")
    public Integer getAdult() {
        return adult;
    }

    @JsonProperty("adult")
    public boolean setAdult(Integer adult) {
        this.adult = adult;
        return true;
    }

    @JsonProperty("child")
    public Integer getChild() {
        return child;
    }

    @JsonProperty("child")
    public boolean setChild(Integer child) {
        this.child = child;
        return true;
    }

    @JsonProperty("infant")
    public Integer getInfant() {
        return infant;
    }

    @JsonProperty("infant")
    public boolean setInfant(Integer infant) {
        this.infant = infant;
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

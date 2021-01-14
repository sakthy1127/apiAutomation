package com.tajawal.api.autocomplete.response.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "locations",
        "hotels"
})
public class AutoCompletResponse {

    @JsonProperty("locations")
    private List<Location> locations = null;
    @JsonProperty("hotels")
    private List<Hotel> hotels = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @JsonProperty("hotels")
    public List<Hotel> getHotels() {
        return hotels;
    }

    @JsonProperty("hotels")
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
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

package com.tajawal.api.autocomplete.response.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "typeNameEn",
        "typeNameAr"
})
public class GoogleType {

    @JsonProperty("typeNameEn")
    private String typeNameEn;
    @JsonProperty("typeNameAr")
    private String typeNameAr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("typeNameEn")
    public String getTypeNameEn() {
        return typeNameEn;
    }

    @JsonProperty("typeNameEn")
    public void setTypeNameEn(String typeNameEn) {
        this.typeNameEn = typeNameEn;
    }

    @JsonProperty("typeNameAr")
    public String getTypeNameAr() {
        return typeNameAr;
    }

    @JsonProperty("typeNameAr")
    public void setTypeNameAr(String typeNameAr) {
        this.typeNameAr = typeNameAr;
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

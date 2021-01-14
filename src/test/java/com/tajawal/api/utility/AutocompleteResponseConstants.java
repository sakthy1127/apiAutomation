package com.tajawal.api.utility;

/**
 * These are the constant value that is used for autocomplete resposne
 *
 * @user Sakthy
 */
public class AutocompleteResponseConstants {
    public static final String locationsLst_key = "locations";
    public static final String location_name_key = "locations[0].name";
    public static final String location_city_key = "locations[0].city";
    public static final String location_country_key = "locations[0].country";
    public static final String location_displayType_key = "locations[0].displayType";
    public static final String location_placeId_key = "locations[0].placeId";
    public static final String location_source_key = "locations[0].source";
    public static final String location_googleType_key = "locations[0].googleType";
    public static final String location_googleType_typeNameEn_key = "locations[0].googleType.typeNameEn";
    public static final String location_googleType_typeNameAr_key = "locations[0].googleType.typeNameAr";
    public static final String hotelsLst_key = "hotels";
    public static final String hotel_hotelId_key = "hotels[0].hotelId";
    public static final String hotel_name_key = "hotels[0].name";
    public static final String hotel_city_key = "hotels[0].city";
    public static final String hotel_country_key = "hotels[0].country";
    public static final String hotel_thumbnail_url_key = "hotels[0].thumbnail_url";
    public static final String hotel_displayType_key = "hotels[0].displayType";
    public static final String hotel_latitude_key = "hotels[0].latitude";
    public static final String hotel_longitude_key = "hotels[0].longitude";
    public static final String autocomplete_rsp_schema = "/getAutoCompleteSchema.json";
    public static final String autocomplete_display_type_location_value = "Location";
    public static final String autocomplete_display_type_hotel_value = "Hotel";
    public AutocompleteResponseConstants() {
    }
}

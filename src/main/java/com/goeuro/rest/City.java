package com.goeuro.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is a Domain class that will contain the data representation for the City object
 * 
 * @author Simon Njenga
 * @since 0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    private Long _id;
    private String key;
    private String name;
    private String fullName;
    private String iata_airport_code;
    private String type;
    private String country;
    private GeoPosition geo_position;
    private Long locationId;
    private boolean inEurope;
    private String countryCode;
    private boolean coreCountry;
    private String distance;

    /**
     * Public default constructor
     */
    public City() {		
    }

    /**
     * @return the _id
     */
    public Long get_id() {
        return _id;
    }

    /**
     * @param id the _id to set
     */
    public void set_id(Long id) {
        _id = id;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the iata_airport_code
     */
    public String getIata_airport_code() {
        return iata_airport_code;
    }

    /**
     * @param iataAirportCode the iata_airport_code to set
     */
    public void setIata_airport_code(String iataAirportCode) {
        iata_airport_code = iataAirportCode;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the geo_position
     */
    public GeoPosition getGeo_position() {
        return geo_position;
    }

    /**
     * @param geoPosition the geo_position to set
     */
    public void setGeo_position(GeoPosition geoPosition) {
        geo_position = geoPosition;
    }

    /**
     * @return the locationId
    */
    public Long getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the inEurope
     */
    public boolean isInEurope() {
        return inEurope;
    }

    /**
     * @param inEurope the inEurope to set
     */
    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

   /**
    * @return the coreCountry
    */
    public boolean isCoreCountry() {
        return coreCountry;
    }

    /**
     * @param coreCountry the coreCountry to set
    */
    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    /**
     * @return the distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "City{_id='" + _id + '\'' + ", key=" + key + ", name=" + name + ", fullName=" + fullName + 
            ", iata_airport_code=" + iata_airport_code + ", type=" + type + ", country=" + country +
            ", geo_position=" + geo_position + ", locationId=" + locationId + ", inEurope=" + inEurope +
            ", countryCode=" + countryCode + ", coreCountry=" + coreCountry + ", distance=" + distance + '}';
    }
}

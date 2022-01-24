package pl.tom.cart.service.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String city;

    @JsonProperty("street_name")
    private String streetName;

    @JsonProperty("street_address")
    private String streetAddress;

    @JsonProperty("zip_code")
    private int zipCode;

    private String state;

    private String country;

    public Address(String city, String streetName, String streetAddress, int zipCode, String state, String country){
        this.city = city;
        this.streetName = streetName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZipCode() {
        return String.valueOf(zipCode);
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

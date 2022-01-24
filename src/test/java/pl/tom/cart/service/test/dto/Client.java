package pl.tom.cart.service.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

    private int id;

    private String password;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("username")
    private String clientName;

    private String email;

    private String gender;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    private Address address;

    public Client(int id, String password, String firstName, String lastName, String clientName, String email, String gender, String phoneNumber, String dateOfBirth, Address address){
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientName = clientName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Full name: %s %s, dateOfBirth: %s", firstName, lastName, dateOfBirth);
    }
}

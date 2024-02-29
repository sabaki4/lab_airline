package com.example.airline_api.models;

public class NewPassengerDTO {
    private String name;
    private String contact;

    public NewPassengerDTO(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public NewPassengerDTO() {
    }

//     GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

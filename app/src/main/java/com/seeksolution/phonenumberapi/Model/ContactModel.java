package com.seeksolution.phonenumberapi.Model;

public class ContactModel {

    private String message;

    public ContactModel() {
    }

    public ContactModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

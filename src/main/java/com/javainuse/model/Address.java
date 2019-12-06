package com.javainuse.model;
import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Embeddable
@Component
public class Address implements Serializable {
	
	
    private String city;
    private String zip;


    public Address() {
    }

    public Address(String street, String city, String zip, String state) {
        this.city = city;
        this.zip = zip;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

  

    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

}

package com.example.myapi;


import javax.persistence.*;

@Entity
@Table(name ="addresses")
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name="id_klient")
    private Long idClient;

    @Column(nullable = false,name="email",length = 50)
    private String email;

    @Column(nullable = false,name="miasto",length = 50)
    private String city;

    @Column(nullable = false,name="ulica",length = 50)
    private String street;

    @Column(nullable = false,name="numer_ulicy",length = 10)
    private String streetNumber;

    @Column(name="numer_lokalu",length = 10)
    private String apartmentNumber;

    @Column(nullable = false,name="kod_pocztowy")
    private int zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


}

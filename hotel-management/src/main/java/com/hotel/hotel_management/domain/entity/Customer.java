package com.hotelmanagement.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    private String phone;

    @Enumerated(EnumType.STRING)
    private IdentityType identityType;

    private String identityNumber;

    public Customer() {}

    public Customer(String fullName, String phone, IdentityType identityType, String identityNumber) {
        this.fullName = fullName;
        this.phone = phone;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public IdentityType getIdentityType() { return identityType; }
    public String getIdentityNumber() { return identityNumber; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setIdentityType(IdentityType identityType) { this.identityType = identityType; }
    public void setIdentityNumber(String identityNumber) { this.identityNumber = identityNumber; }
}

package com.springexception.exceptionhandling.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private String userId;
    private String userName;

    private String userEmail;
    private String userPassword;
}

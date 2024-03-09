package com.api.crud.models;

import jakarta.persistence.*;

@Entity // columna de la tabla
@Table(name= "user") //contra que tabla se va a mapear nuestra bbdd
public class UserModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id

    private Long id;

    @Column //columna
    private String firstname;
    @Column
    private String lastName;
    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.endpointupdateuser.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="USERS")
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer id;


    @Column(unique = true)
    private String email;

    @Column
    private String nome;

    public UserEntity get(){
        return this;
    }
}

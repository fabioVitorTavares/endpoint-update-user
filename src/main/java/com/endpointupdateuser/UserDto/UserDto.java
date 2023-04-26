package com.endpointupdateuser.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data

public class UserDto {


    private String email;

    private String nome;
}

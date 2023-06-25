package com.taskmaneger.demo.web.dto;


import lombok.Data;

import java.util.Date;


@Data
public class UserDto {
    private long id;

    private String firstName;
    private String lastName;
    private long nationalCode;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private RoleDto role;
    private String address;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode=" + nationalCode +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", address='" + address + '\'' +
                '}';
    }
}

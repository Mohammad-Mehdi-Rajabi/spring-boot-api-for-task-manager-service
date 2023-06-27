package com.taskmaneger.demo.web.dataModel;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class User {


    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;

    private String firstName;
    private String lastName;
    private long nationalCode;
    private Date birthDate;
    private String phoneNumber;
    private String email;

    @OneToOne
    @JoinColumn(name = "RoleId", nullable = false)
    private Role role;






    private String address;

    @Override
    public String toString() {
        return "User{" +
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

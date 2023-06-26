package com.taskmaneger.demo.web.dataModel;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Job {
    @Id
    @SequenceGenerator(sequenceName = "job_sequence", name = "job_sequence", initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_sequence")
    private long id;

    @OneToOne
    private Project project;

    @ManyToMany
    private List<User> userList;

    private String title;

    private Date expireDate;

    @Column(length = 10000)
    private String about;


}

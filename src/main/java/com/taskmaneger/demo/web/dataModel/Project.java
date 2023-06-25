package com.taskmaneger.demo.web.dataModel;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Project {
    @Id
    @SequenceGenerator(initialValue = 10000, name = "project_sequence", sequenceName = "project_sequence")
    @GeneratedValue(generator = "project_sequence", strategy = GenerationType.SEQUENCE)
    private long id;

    private String subject;

    @Column(length = 100000)
    private String about;

    @OneToMany
    private List<User> userList;

    private Date startDate;
    private Date endDate;


    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", about='" + about + '\'' +
                ", userList=" + userList +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

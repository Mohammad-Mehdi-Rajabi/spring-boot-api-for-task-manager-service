package com.taskmaneger.demo.web.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class JobDto {

    private long id;

    private ProjectDtoForReq project;

    private List<UserDtoForReq> userList;

    private String title;

    private Date expireDate;

    private String about;

    @Override
    public String toString() {
        return "JobDto{" +
                "id=" + id +
                ", project=" + project +
                ", userList=" + userList +
                ", title='" + title + '\'' +
                ", expireDate=" + expireDate +
                ", about='" + about + '\'' +
                '}';
    }
}

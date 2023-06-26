package com.taskmaneger.demo.web.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Component
public class ProjectDto {

    private long id;
    private String subject;
    private String about;
    private List<UserDtoForReq> userList;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "ProjectDto{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", about='" + about + '\'' +
                ", userList=" + userList +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

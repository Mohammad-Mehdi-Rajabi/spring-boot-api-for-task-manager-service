package com.taskmaneger.demo.web.dto;


import lombok.Data;

@Data
public class ProjectDtoForJobReq {
    private long id;

    @Override
    public String toString() {
        return "ProjectDtoForJobReq{" +
                "id=" + id +
                '}';
    }
}

package com.taskmaneger.demo.web.dto;


import lombok.Data;

@Data
public class ProjectDtoForReq {
    private long id;

    @Override
    public String toString() {
        return "ProjectDtoForReq{" +
                "id=" + id +
                '}';
    }
}

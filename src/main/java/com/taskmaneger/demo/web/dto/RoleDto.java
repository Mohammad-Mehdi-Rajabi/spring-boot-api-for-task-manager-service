package com.taskmaneger.demo.web.dto;

import lombok.Data;

@Data
public class RoleDto {

    private long id;

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                '}';
    }
}

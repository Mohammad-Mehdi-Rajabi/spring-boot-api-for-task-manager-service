package com.taskmaneger.demo.web.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDtoForProjectReq {

    private long id;

    @Override
    public String toString() {
        return "UserDtoForProjectReq{" +
                "id=" + id +
                '}';
    }
}

package com.taskmaneger.demo.web.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDtoForReq {

    private long id;

    @Override
    public String toString() {
        return "UserDtoForReq{" +
                "id=" + id +
                '}';
    }
}

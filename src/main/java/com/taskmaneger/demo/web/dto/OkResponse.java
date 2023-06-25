package com.taskmaneger.demo.web.dto;

import lombok.Data;

@Data
public class OkResponse<T> {
    private int code;
    private String massage;
    private T body;

    public OkResponse(int code, String massage, T t) {
        this.code = code;
        this.massage = massage;
        this.body = t;
    }

    @Override
    public String toString() {
        return "OkResponse{" +
                "code=" + code +
                ", massage='" + massage + '\'' +
                ", body=" + body +
                '}';
    }
}

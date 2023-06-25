package com.taskmaneger.demo.web.dto;

import lombok.Data;

@Data
public class Response<T> {
    private int code;
    private String massage;
    private T body;

    public Response(int code, String massage, T t) {
        this.code = code;
        this.massage = massage;
        this.body = t;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", massage='" + massage + '\'' +
                ", body=" + body +
                '}';
    }
}

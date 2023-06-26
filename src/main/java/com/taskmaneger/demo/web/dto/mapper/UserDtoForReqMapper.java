package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.UserDtoForReq;
import com.taskmaneger.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoForReqMapper implements Mapper<UserDtoForReq, User> {

    private UserService userService;

    @Autowired
    public UserDtoForReqMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDtoForReq modelToDto(User model) {
        UserDtoForReq userDtoForReq = new UserDtoForReq();
        userDtoForReq.setId(model.getId());
        return userDtoForReq;
    }

    @Override
    public User DtoToModel(UserDtoForReq dto) {
        User userById = userService.getUserById(dto.getId());
        return userById;
    }
}

package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.UserDtoForProjectReq;
import com.taskmaneger.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoForProjectReqMapper implements Mapper<UserDtoForProjectReq, User> {

    private UserService userService;

    @Autowired
    public UserDtoForProjectReqMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDtoForProjectReq modelToDto(User model) {
        UserDtoForProjectReq userDtoForProjectReq = new UserDtoForProjectReq();
        userDtoForProjectReq.setId(model.getId());
        return userDtoForProjectReq;
    }

    @Override
    public User DtoToModel(UserDtoForProjectReq dto) {
        User userById = userService.getUserById(dto.getId());
        return userById;
    }
}

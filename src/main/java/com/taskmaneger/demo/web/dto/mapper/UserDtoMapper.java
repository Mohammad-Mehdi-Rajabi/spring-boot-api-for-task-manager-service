package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper implements Mapper<UserDto, User> {

    private RoleDtoMapper roleDtoMapper;

    @Autowired
    public UserDtoMapper(RoleDtoMapper roleDtoMapper) {
        this.roleDtoMapper = roleDtoMapper;
    }

    @Override
    public UserDto modelToDto(User model) {
        UserDto userDto = new UserDto();
        userDto.setAddress(model.getAddress());
        userDto.setBirthDate(model.getBirthDate());
        userDto.setEmail(model.getEmail());
        userDto.setFirstName(model.getFirstName());
        userDto.setId(model.getId());
        userDto.setLastName(model.getLastName());
        userDto.setNationalCode(model.getNationalCode());
        userDto.setPhoneNumber(model.getPhoneNumber());
        userDto.setRole(roleDtoMapper.modelToDto(model.getRole()));
        return userDto;
    }

    @Override
    public User DtoToModel(UserDto dto) {
        User user = new User();
        user.setAddress(dto.getAddress());
        user.setBirthDate(dto.getBirthDate());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setId(dto.getId());
        user.setLastName(dto.getLastName());
        user.setNationalCode(dto.getNationalCode());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRole(roleDtoMapper.DtoToModel(dto.getRole()));
        return user;
    }
}

package com.taskmaneger.demo.web.service;

import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.dto.UserDto;
import com.taskmaneger.demo.web.dto.mapper.UserDtoMapper;
import com.taskmaneger.demo.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserDtoMapper userDtoMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    public Response<User> addNewUser(UserDto userDto) {
        User result = userRepository.save(userDtoMapper.DtoToModel(userDto));
        return new Response<User>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
    }

    @Transactional
    public Response<?> deleteUser(Long id) {
        userRepository.deleteUserById(id);
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

    public User getUserById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    @Transactional
    public Response<?> editUser(Long id, UserDto userDto) {
        userRepository.editUserById(id, userDtoMapper.DtoToModel(userDto));
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }


}

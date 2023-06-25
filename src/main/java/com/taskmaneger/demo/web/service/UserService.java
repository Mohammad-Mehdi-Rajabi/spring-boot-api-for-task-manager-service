package com.taskmaneger.demo.web.service;

import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.OkResponse;
import com.taskmaneger.demo.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public OkResponse<User> addNewUser(User user) {
        User result = userRepository.save(user);
        return new OkResponse<User>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
    }

   /* public OkResponse<?> deleteUser(Long id) {
        Optional<User> result = userRepository.deleteUserById(id);
        return new OkResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
    }

    public OkResponse<?> editUser(Long id, User user) {
        Optional<User> result = userRepository.editUserById(id, user);
        return new OkResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
    }*/

    public List<User> getAll() {
        return userRepository.findAll();
    }
}

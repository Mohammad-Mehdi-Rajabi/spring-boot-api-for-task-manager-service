package com.taskmaneger.demo.web.service;

import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Response<User> addNewUser(User user) {
        User result = userRepository.save(user);
        return new Response<User>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
    }

   /* public Response<?> deleteUser(Long id) {
        Optional<User> result = userRepository.deleteUserById(id);
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
    }

    public Response<?> editUser(Long id, User user) {
        Optional<User> result = userRepository.editUserById(id, user);
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
    }*/

    public List<User> getAll() {
        return userRepository.findAll();
    }
}

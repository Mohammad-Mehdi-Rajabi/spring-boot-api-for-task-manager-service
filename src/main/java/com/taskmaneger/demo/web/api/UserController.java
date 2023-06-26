package com.taskmaneger.demo.web.api;


import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.dto.UserDto;
import com.taskmaneger.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/addUser")
    public ResponseEntity<?> addNewUser(@RequestBody UserDto userDto) {
        Response<User> userResponse = userService.addNewUser(userDto);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Response<?> okResponse = userService.deleteUser(id);
        return new ResponseEntity<>(okResponse, HttpStatus.OK);
    }


    @PutMapping("/editUser/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        Response<?> okResponse = userService.editUser(id, userDto);
        return new ResponseEntity<>(okResponse, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        User userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
}

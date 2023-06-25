package com.taskmaneger.demo.web.api;


import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.OkResponse;
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
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        OkResponse<User> userOkResponse = userService.addNewUser(user);
        return new ResponseEntity<>(userOkResponse, HttpStatus.OK);
    }

   /* @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        OkResponse<?> okResponse = userService.deleteUser(id);
        return new ResponseEntity<>(okResponse, HttpStatus.OK);
    }*/


   /* @PutMapping("/editUser/{id")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody User user) {
        OkResponse<?> okResponse = userService.editUser(id, user);
        return new ResponseEntity<>(okResponse, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }*/
}

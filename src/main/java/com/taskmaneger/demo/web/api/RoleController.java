package com.taskmaneger.demo.web.api;


import com.taskmaneger.demo.web.dataModel.Role;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role/")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllRoles() {
        List<Role> allRoles = roleService.getAllRoles();
        return ResponseEntity.ok(allRoles);
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> addNewRole(@RequestBody Role role) {
        Response<Role> roleResponse = roleService.addNewRole(role);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }
}

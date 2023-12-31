package com.taskmaneger.demo.web.controller;


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

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllRoles() {
        List<Role> allRoles = roleService.getAllRoles();
        return ResponseEntity.ok(allRoles);
    }

    @PostMapping(value = "/addRole")
    public ResponseEntity<?> addNewRole(@RequestBody Role role) {
        Response<Role> roleResponse = roleService.addNewRole(role);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteRoleById/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable long id) {
        Response<?> response = roleService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getRoleById/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable long id) {
        Role role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PutMapping(value = "/editRoleById/{id}")
    public ResponseEntity<?> edit(@PathVariable long id, @RequestBody Role role) {
        return new ResponseEntity<>(roleService.update(id, role), HttpStatus.OK);
    }
}

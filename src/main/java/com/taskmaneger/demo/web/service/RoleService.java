package com.taskmaneger.demo.web.service;


import com.taskmaneger.demo.web.dataModel.Role;
import com.taskmaneger.demo.web.dto.OkResponse;
import com.taskmaneger.demo.web.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public OkResponse<Role> addNewRole(Role role) {

        return new OkResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), roleRepository.save(role));
    }
}

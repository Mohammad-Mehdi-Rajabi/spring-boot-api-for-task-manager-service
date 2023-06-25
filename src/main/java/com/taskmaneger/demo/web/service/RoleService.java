package com.taskmaneger.demo.web.service;


import com.taskmaneger.demo.web.dataModel.Role;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Response<Role> addNewRole(Role role) {
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), roleRepository.save(role));
    }

    public Role getRoleById(Long id) {
        Optional<Role> byId = roleRepository.findById(id);
        return byId.orElse(null);
    }
}

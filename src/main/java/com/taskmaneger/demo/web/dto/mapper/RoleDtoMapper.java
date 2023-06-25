package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.Role;
import com.taskmaneger.demo.web.dto.RoleDto;
import com.taskmaneger.demo.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleDtoMapper implements Mapper<RoleDto, Role> {
    private RoleService roleService;

    @Autowired
    public RoleDtoMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto modelToDto(Role model) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(model.getId());
        return roleDto;
    }

    @Override
    public Role DtoToModel(RoleDto dto) {
        Role roleById = roleService.getRoleById(dto.getId());
        return roleById;
    }
}

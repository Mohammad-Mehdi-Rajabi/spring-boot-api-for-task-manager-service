package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.Project;
import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.ProjectDto;
import com.taskmaneger.demo.web.dto.UserDtoForReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectDtoMapper implements Mapper<ProjectDto, Project> {

    private UserDtoForReqMapper userDtoForReqMapper;

    @Autowired
    public ProjectDtoMapper(UserDtoForReqMapper userDtoForReqMapper) {
        this.userDtoForReqMapper = userDtoForReqMapper;
    }

    @Override
    public ProjectDto modelToDto(Project model) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setAbout(model.getAbout());
        projectDto.setEndDate(model.getEndDate());
        projectDto.setId(model.getId());
        projectDto.setStartDate(model.getStartDate());
        projectDto.setSubject(model.getSubject());
        List<UserDtoForReq> userDtoForReqList = new ArrayList<>();
        model.getUserList().forEach(user -> {
            userDtoForReqList.add(userDtoForReqMapper.modelToDto(user));
        });
        projectDto.setUserList(userDtoForReqList);
        return projectDto;
    }

    @Override
    public Project DtoToModel(ProjectDto dto) {
        Project project = new Project();
        project.setAbout(dto.getAbout());
        project.setEndDate(dto.getEndDate());
        project.setId(dto.getId());
        project.setStartDate(dto.getStartDate());
        project.setSubject(dto.getSubject());
        List<User> userList = new ArrayList<>();
        dto.getUserList().forEach(user -> {
            userList.add(userDtoForReqMapper.DtoToModel(user));
        });
        project.setUserList(userList);
        return project;
    }
}

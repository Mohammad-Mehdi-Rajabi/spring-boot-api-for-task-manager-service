package com.taskmaneger.demo.web.service;


import com.taskmaneger.demo.web.dataModel.Project;
import com.taskmaneger.demo.web.dto.ProjectDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.dto.mapper.ProjectDtoMapper;
import com.taskmaneger.demo.web.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    private ProjectDtoMapper projectDtoMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ProjectDtoMapper projectDtoMapper) {
        this.projectRepository = projectRepository;
        this.projectDtoMapper = projectDtoMapper;
    }

    public Response<?> addProject(ProjectDto projectDto) {
        Project save = projectRepository.save(projectDtoMapper.DtoToModel(projectDto));
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), save);
    }

    @Transactional
    public Response<?> editProjectById(long id, ProjectDto projectDto) {
        projectRepository.editProjectById(id, projectDtoMapper.DtoToModel(projectDto));
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }
}

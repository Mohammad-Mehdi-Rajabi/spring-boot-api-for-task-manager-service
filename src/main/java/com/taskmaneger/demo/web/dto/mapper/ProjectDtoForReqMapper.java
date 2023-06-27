package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.Project;
import com.taskmaneger.demo.web.dto.ProjectDtoForReq;
import com.taskmaneger.demo.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoForReqMapper implements Mapper<ProjectDtoForReq, Project> {

    private ProjectService projectService;


    @Autowired
    public ProjectDtoForReqMapper(ProjectService projectService) {
        this.projectService = projectService;
    }


    @Override
    public ProjectDtoForReq modelToDto(Project model) {
        ProjectDtoForReq projectDtoForReq = new ProjectDtoForReq();
        projectDtoForReq.setId(model.getId());
        return projectDtoForReq;
    }

    @Override
    public Project DtoToModel(ProjectDtoForReq dto) {
        return projectService.getProjectById(dto.getId());
    }
}

package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.Project;
import com.taskmaneger.demo.web.dto.ProjectDtoForJobReq;
import com.taskmaneger.demo.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoForJobReqMapper implements Mapper<ProjectDtoForJobReq, Project> {

    private ProjectService projectService;


    @Autowired
    public ProjectDtoForJobReqMapper(ProjectService projectService) {
        this.projectService = projectService;
    }


    @Override
    public ProjectDtoForJobReq modelToDto(Project model) {
        ProjectDtoForJobReq projectDtoForJobReq = new ProjectDtoForJobReq();
        projectDtoForJobReq.setId(model.getId());
        return projectDtoForJobReq;
    }

    @Override
    public Project DtoToModel(ProjectDtoForJobReq dto) {
        return projectService.getProjectById(dto.getId());
    }
}

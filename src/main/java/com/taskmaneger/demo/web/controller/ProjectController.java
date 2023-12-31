package com.taskmaneger.demo.web.controller;


import com.taskmaneger.demo.web.dataModel.Project;
import com.taskmaneger.demo.web.dto.ProjectDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project/")
public class ProjectController {

    private ProjectService projectService;


    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping(value = "/addProject")
    public ResponseEntity<?> addProject(@RequestBody ProjectDto projectDto) {
        Response<?> response = projectService.addProject(projectDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "editProject/{id}")
    public ResponseEntity<?> editProjectById(@PathVariable long id, @RequestBody ProjectDto projectDto) {
        Response<?> response = projectService.editProjectById(id, projectDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteProject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable long id) {
        Response<?> response = projectService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllProject() {
        List<?> all = projectService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(value = "/getProjectById/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable long id) {
        Project project = projectService.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}

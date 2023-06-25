package com.taskmaneger.demo.web.api;


import com.taskmaneger.demo.web.dto.ProjectDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project/")
public class ProjectController {

    private ProjectService projectService;


    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping("/addProject")
    public ResponseEntity<?> addProject(@RequestBody ProjectDto projectDto) {
        Response<?> response = projectService.addProject(projectDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("editProject/{id}")
    public ResponseEntity<?> editProjectById(@PathVariable long id, @RequestBody ProjectDto projectDto) {
        Response<?> response = projectService.editProjectById(id, projectDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
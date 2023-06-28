package com.taskmaneger.demo.web.controller;


import com.taskmaneger.demo.web.dataModel.Job;
import com.taskmaneger.demo.web.dto.JobDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job/")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(value = "addJob")
    public ResponseEntity<?> addJob(@RequestBody JobDto job) {
        Response<?> response = jobService.addJob(job);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteJob/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        Response<?> response = jobService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping(value = "/getJobById/{id}")
    public ResponseEntity<?> getJobById(@PathVariable long id) {
        Job jobById = jobService.getJobById(id);
        return new ResponseEntity<>(jobById, HttpStatus.OK);
    }


    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(jobService.getAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/editJob/{id}")
    public ResponseEntity<?> editJob(@PathVariable long id, @RequestBody JobDto jobDto) {
        return new ResponseEntity<>(jobService.editJob(id, jobDto), HttpStatus.OK);
    }
}

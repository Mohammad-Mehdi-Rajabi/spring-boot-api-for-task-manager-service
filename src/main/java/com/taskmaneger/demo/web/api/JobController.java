package com.taskmaneger.demo.web.api;


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

    @PostMapping("addJob")
    public ResponseEntity<?> addJob(@RequestBody JobDto job) {
        Response<?> response = jobService.addJob(job);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        Response<?> response = jobService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

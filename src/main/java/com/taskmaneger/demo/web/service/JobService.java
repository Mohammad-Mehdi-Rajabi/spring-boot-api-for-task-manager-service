package com.taskmaneger.demo.web.service;


import com.taskmaneger.demo.web.dataModel.Job;
import com.taskmaneger.demo.web.dto.JobDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.dto.mapper.JobDtoMapper;
import com.taskmaneger.demo.web.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {

    private JobRepository jobRepository;
    private JobDtoMapper jobDtoMapper;

    @Autowired
    public JobService(JobRepository jobRepository, JobDtoMapper jobDtoMapper) {
        this.jobRepository = jobRepository;
        this.jobDtoMapper = jobDtoMapper;
    }


    public Response<?> addJob(JobDto job) {
        Job save = jobRepository.save(jobDtoMapper.DtoToModel(job));
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), save);
    }

    public Job getJobById(Long id) {
        Optional<Job> byId = jobRepository.findById(id);
        return byId.orElse(null);
    }

    public Response<?> deleteById(long id) {
        jobRepository.deleteById(id);
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }
}

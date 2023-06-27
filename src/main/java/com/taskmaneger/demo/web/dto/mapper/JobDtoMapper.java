package com.taskmaneger.demo.web.dto.mapper;


import com.taskmaneger.demo.web.dataModel.Job;
import com.taskmaneger.demo.web.dataModel.User;
import com.taskmaneger.demo.web.dto.JobDto;
import com.taskmaneger.demo.web.dto.UserDtoForReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobDtoMapper implements Mapper<JobDto, Job> {
    private ProjectDtoForReqMapper projectDtoForReqMapper;
    private UserDtoForReqMapper userDtoForReqMapper;


    @Autowired
    public JobDtoMapper(ProjectDtoForReqMapper projectDtoForReqMapper, UserDtoForReqMapper userDtoForReqMapper) {
        this.projectDtoForReqMapper = projectDtoForReqMapper;
        this.userDtoForReqMapper = userDtoForReqMapper;
    }


    @Override
    public JobDto modelToDto(Job model) {
        JobDto jobDto = new JobDto();
        jobDto.setAbout(model.getAbout());
        jobDto.setExpireDate(model.getExpireDate());
        jobDto.setId(model.getId());
        jobDto.setProject(projectDtoForReqMapper.modelToDto(model.getProject()));
        jobDto.setTitle(model.getTitle());
        List<UserDtoForReq> userDtoForReqList =
                new ArrayList<>();
        model.getUserList().forEach(user -> {
            userDtoForReqList.add(userDtoForReqMapper.modelToDto(user));
        });
        jobDto.setUserList(userDtoForReqList);
        return jobDto;
    }

    @Override
    public Job DtoToModel(JobDto dto) {
        Job job = new Job();
        job.setAbout(dto.getAbout());
        job.setExpireDate(dto.getExpireDate());
        job.setId(dto.getId());
        job.setProject(projectDtoForReqMapper.DtoToModel(dto.getProject()));
        job.setTitle(dto.getTitle());
        List<User> userDtoForReqList =
                new ArrayList<>();
        dto.getUserList().forEach(user -> {
            userDtoForReqList.add(userDtoForReqMapper.DtoToModel(user));
        });
        job.setUserList(userDtoForReqList);
        return job;
    }
}

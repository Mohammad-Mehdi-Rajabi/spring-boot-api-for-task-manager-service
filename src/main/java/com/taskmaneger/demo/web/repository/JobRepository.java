package com.taskmaneger.demo.web.repository;

import com.taskmaneger.demo.web.dataModel.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}

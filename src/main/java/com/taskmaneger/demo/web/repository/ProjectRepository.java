package com.taskmaneger.demo.web.repository;

import com.taskmaneger.demo.web.dataModel.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}

package com.taskmaneger.demo.web.repository;

import com.taskmaneger.demo.web.dataModel.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Modifying
    @Query("UPDATE Project p " +
            "SET p.about = :#{#project.about}," +
            " p.endDate = :#{#project.endDate}," +
            " p.startDate = :#{#project.startDate}," +
            " p.subject = :#{#project.subject}," +
            " p.userList = :#{#project.userList}" +
            " where p.id= :id")
    void editProjectById(@Param("id") Long id, @Param("project") Project project);
}

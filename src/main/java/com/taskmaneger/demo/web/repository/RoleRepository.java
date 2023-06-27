package com.taskmaneger.demo.web.repository;

import com.taskmaneger.demo.web.dataModel.Role;
import com.taskmaneger.demo.web.dataModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Modifying
    @Query("UPDATE Role r " +
            "SET r.roleName = :#{#role.roleName}," +
            " r.type = :#{#role.type}" +
            " where r.id= :id")
    void editRoleById(@Param("id") Long id, @Param("role") Role role);
}

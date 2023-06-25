package com.taskmaneger.demo.web.repository;

import com.taskmaneger.demo.web.dataModel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

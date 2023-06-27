package com.taskmaneger.demo.web.repository;


import com.taskmaneger.demo.web.dataModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

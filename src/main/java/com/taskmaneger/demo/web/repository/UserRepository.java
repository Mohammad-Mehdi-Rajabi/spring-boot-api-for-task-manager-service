package com.taskmaneger.demo.web.repository;


import com.taskmaneger.demo.web.dataModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*@Query("delete from taskmanager.user where id= :id")
    Optional<User> deleteUserById(@Param("id") Long id);

    @Query("UPDATE taskmanager.user " +
            "SET firstName = :user.firstName," +
            " lastName = :user.lastName," +
            " nationalCode = :user.nationalCode," +
            " birthDate = :user.birthDate," +
            " phoneNumber = :user.phoneNumber," +
            " email = :user.email," +
            "Role = :user.Role WHERE id= :id")
    Optional<User> editUserById(@Param("id") Long id, @Param("user") User user);*/

}

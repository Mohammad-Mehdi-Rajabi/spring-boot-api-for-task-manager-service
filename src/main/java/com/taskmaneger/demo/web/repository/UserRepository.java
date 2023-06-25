package com.taskmaneger.demo.web.repository;


import com.taskmaneger.demo.web.dataModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("delete from User u where u.id=:id")
    void deleteUserById(@Param("id") Long id);


    @Modifying
    @Query("UPDATE User u " +
            "SET u.firstName = :#{#user.firstName}," +
            " u.lastName = :#{#user.lastName}," +
            " u.nationalCode = :#{#user.nationalCode}," +
            " u.birthDate = :#{#user.birthDate}," +
            " u.phoneNumber = :#{#user.phoneNumber}," +
            " u.email = :#{#user.email}," +
            "u.role = :#{#user.role } where u.id= :id")
    void editUserById(@Param("id") Long id, @Param("user") User user);

}

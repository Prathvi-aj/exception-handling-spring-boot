package com.springexception.exceptionhandling.repos;

import com.springexception.exceptionhandling.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findByUserEmail(String email);

    User findByUserId(String userId);
    //List<User> getAllUser();
}

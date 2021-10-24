package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findByEmail(String email);
}

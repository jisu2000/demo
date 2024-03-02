package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserEO;

public interface UserRepository extends JpaRepository<UserEO,Integer>{

}

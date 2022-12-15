package com.codewithravikiran.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithravikiran.blog.entities.User;

public interface userRepo  extends JpaRepository<User, Integer>{

}

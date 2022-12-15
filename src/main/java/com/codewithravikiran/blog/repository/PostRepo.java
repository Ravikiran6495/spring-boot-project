package com.codewithravikiran.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithravikiran.blog.entities.Post;
import com.codewithravikiran.blog.entities.User;

public interface PostRepo  extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	

}

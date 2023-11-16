package com.codewithabdul.blog.repositories;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabdul.blog.entities.Category;
import com.codewithabdul.blog.entities.Post;

public interface PostRepo  extends JpaRepository<Post, Integer>{
	
	List<Post> findbyUser(User user);
	List<Post> findbyCategory(Category category);
	

}

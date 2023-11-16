package com.codewithabdul.blog.services;

import java.util.List;

import com.codewithabdul.blog.entities.Post;
import com.codewithabdul.blog.payloads.PostDto;

public interface PostService {

	
	//create
	
	Post createPost(PostDto postDto);
	
	//update
	
	Post updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletepost(Integer postId);
	
	
	//getAll post
	
	List<Post>getAllpost();
	
	//get Single post
	
	Post getpostById(Integer postId);
	
	//get All post by category
	
	List<Post> getPostByCategory(Integer postId);
	
	//get All Post By User
	List<Post> getPostByUser(Integer userId);
}

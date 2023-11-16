package com.codewithabdul.blog.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithabdul.blog.entities.Post;
import com.codewithabdul.blog.payloads.PostDto;
import com.codewithabdul.blog.repositories.PostRepo;
import com.codewithabdul.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Post createPost(PostDto postDto) {
		return null;
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletepost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllpost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getpostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCategory(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

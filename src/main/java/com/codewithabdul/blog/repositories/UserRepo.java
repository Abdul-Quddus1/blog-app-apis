package com.codewithabdul.blog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabdul.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {


	//com.codewithabdul.blog.entities.User save(com.codewithabdul.blog.entities.User user);

}

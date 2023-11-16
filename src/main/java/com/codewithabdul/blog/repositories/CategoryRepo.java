package com.codewithabdul.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabdul.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}

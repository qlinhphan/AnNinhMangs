package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Author;


public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public Author save(Author auth);

	public List<Author> findAll();

	public Author findById(int id);

	public void deleteById(int id);
}

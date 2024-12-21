package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public Author save(Author auth);

	public Page<Author> findAll(Pageable pageable);

	public Author findById(int id);

	public void deleteById(int id);

	public List<Author> findAll();

	public Author findByFullName(String name);
}

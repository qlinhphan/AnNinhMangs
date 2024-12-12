package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Author;
import com.example.springWEB.domain.Book;
import com.example.springWEB.repository.AuthorRepository;

@Service
public class AuthorService {
	private AuthorRepository authRepo;

	public AuthorService(AuthorRepository authRepository) {
		this.authRepo = authRepository;
	}

	public Author saveAuthor(Author auth) {
		return this.authRepo.save(auth);
	}

	public List<Author> findAllAuthors() {
		return this.authRepo.findAll();
	}

	public Author findAuthorById(int id) {
		return this.authRepo.findById(id);
	}

	public void deleteAuthorById(int id) {
		this.authRepo.deleteById(id);
	}
}

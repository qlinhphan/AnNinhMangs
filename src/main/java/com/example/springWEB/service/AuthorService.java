package com.example.springWEB.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Author;
// import com.example.springWEB.domain.Book;
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

	public Page<Author> findAllAuthors(Pageable pag) {
		return this.authRepo.findAll(pag);
	}

	public Author findAuthorById(int id) {
		return this.authRepo.findById(id);
	}

	public void deleteAuthorById(int id) {
		this.authRepo.deleteById(id);
	}

	public List<Author> toFindAllAthor() {
		return this.authRepo.findAll();
	}

	public Author findAuthorByName(String name) {
		return this.authRepo.findByFullName(name);
	}
}

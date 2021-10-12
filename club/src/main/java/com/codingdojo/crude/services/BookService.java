package com.codingdojo.crude.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.crude.models.Book;
import com.codingdojo.crude.models.User;
import com.codingdojo.crude.repositories.BookRepository;



@Service
public class BookService {
	
	
	private BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	
	public Book oneBook(Long id ) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
		
	}
	
	
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	
	
	public void destroy(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	
	
	
	
	
}

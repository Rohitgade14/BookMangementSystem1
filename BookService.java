package com.jsp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.Entity1.Book1;
import com.jsp.repository.BookRepository;
@Component
public class BookService {
	@Autowired
	BookRepository bookRepository;	
	  //get all books
     public List<Book1>  getAllBooks() {
    	 List<Book1> list=(List<Book1>)this.bookRepository.findAll();
		return list;
	}
     
     public Book1 getBookById(int id) {
    	    Optional<Book1> optionalBook = bookRepository.findById(id);
    	    return optionalBook.orElse(null);
    	}

     
     public Book1 addBook(Book1 b) {
    	 return  bookRepository.save(b);
    	  
	}
     
     public void deleteBook(int bid) {
    	    bookRepository.deleteById(bid);
    	}

	public void updateBook(Book1 book, int bookId) {
		book.setId(bookId);
	  	bookRepository.save(book);
		
	}
}

package com.jsp.contoller1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Entity1.Book1;
import com.jsp.service.BookService;
@RestController
public class BookContoller1 {
	@Autowired  private BookService bookService;
	
	@GetMapping("/books")
    public ResponseEntity<List<Book1>> getBooks() {
        List<Book1> list = bookService.getAllBooks();
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }
	
	@GetMapping("/books/{id}")
    public ResponseEntity<Book1> getBook(@PathVariable("id") int id) {
        Book1 book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }


    @PostMapping("/books")
    public ResponseEntity<Book1> addBook(@RequestBody Book1 book) {
        try {
            Book1 savedBook = bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	 
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            bookService.deleteBook(bookId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book1> updateBook(@RequestBody Book1 book, @PathVariable("bookId") int bookId) {
        try {
            bookService.updateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

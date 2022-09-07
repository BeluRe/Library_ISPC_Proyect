package com.library.library.controller;

import com.library.library.dto.BookDTO;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> books = bookService.getAll();
        return ResponseEntity.ok().body(books);
    }
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO dto){
        BookDTO bookSaved = bookService.save(dto);
        return ResponseEntity.ok().body(bookSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        BookDTO book = bookService.getBookById(id);
        return ResponseEntity.ok().body(book);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> bookUpdate(@PathVariable Long id, @RequestBody BookDTO book) {
        BookDTO bookUpdated = bookService.update(id, book);
        return ResponseEntity.ok().body(bookUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

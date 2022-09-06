package com.library.library.controller;

import com.library.library.dto.LendingDTO;
import com.library.library.service.BookService;
import com.library.library.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("lendings")
public class LendingController{
    @Autowired
    private LendingService lendingService;
    @Autowired
    private BookService bookService;
    @PostMapping("/{idUser}/books/{idBook}")
    public ResponseEntity<Void>bookReserve(@PathVariable Long idUser, @PathVariable Long idBook,
                                           @RequestBody LendingDTO lending)
    {
        if (!bookService.isAvailable(idBook)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        lendingService.addReserve(idUser, idBook, lending);
        bookService.discountUnit(idBook);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{idLending}")
    public ResponseEntity<Void>returnReserve(@PathVariable Long idLending)
    {
        lendingService.returnLending(idLending);
        deleteReserve(idLending);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //TODO terminar funcion perder libro
    @PutMapping("/{idLending}/lost/")
    public ResponseEntity<Void>reserveLost(@PathVariable Long idLending)
    {
        lendingService.lostBook(idLending);
        deleteReserve(idLending);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{idLending}")
    public ResponseEntity<Void>deleteReserve(@PathVariable Long idLending)
    {
        lendingService.delete(idLending);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

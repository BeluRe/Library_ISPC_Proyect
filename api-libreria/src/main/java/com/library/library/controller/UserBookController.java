package com.library.library.controller;

import com.library.library.dto.UserBookDTO;
import com.library.library.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("lendings")
public class UserBookController {
    @Autowired
    private UserBookService userBookService;

    @PostMapping("/{idUser}/books/{idBook}")
    public ResponseEntity<Void>bookReserve(@PathVariable Long idUser, @PathVariable Long idBook,
                                           @RequestBody UserBookDTO lending)
    {
        userBookService.addBook(idUser, idBook, lending);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

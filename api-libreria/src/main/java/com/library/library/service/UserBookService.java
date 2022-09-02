package com.library.library.service;

import com.library.library.dto.UserBookDTO;

public interface UserBookService {
    void addBook(Long idUser, Long idBook, UserBookDTO dto);
}

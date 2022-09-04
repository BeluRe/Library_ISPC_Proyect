package com.library.library.service;

import com.library.library.dto.BookDTO;
public interface BookService {
    BookDTO save (BookDTO dto);
    BookDTO getBookById(Long id);
    BookDTO update(Long id, BookDTO book);
    void delete (Long id);
}

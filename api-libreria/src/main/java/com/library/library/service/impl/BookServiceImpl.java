package com.library.library.service.impl;

import com.library.library.dto.BookDTO;
import com.library.library.entity.BookEntity;
import com.library.library.mapper.BookMapper;
import com.library.library.repository.BookRepository;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    public BookDTO save(BookDTO dto) {
        BookEntity entity = bookMapper.bookDTO2Entity(dto);
        BookEntity entitySaved = bookRepository.save(entity);
        BookDTO result = bookMapper.bookEntity2DTO(entitySaved, false);
        return result;
    }
    public BookDTO getBookById(Long id) {
        BookEntity entity = bookRepository.getReferenceById(id);
        BookDTO dto = bookMapper.bookEntity2DTO(entity, true);
        return dto;
    }
    public BookDTO update(Long id, BookDTO book) {
        BookEntity entityId = bookRepository.getReferenceById(id);
        BookEntity entity = bookMapper.update(entityId,book);
        BookEntity entityUpdated = bookRepository.save(entity);
        BookDTO result = bookMapper.bookEntity2DTO(entityUpdated, false);
        return result;
    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}

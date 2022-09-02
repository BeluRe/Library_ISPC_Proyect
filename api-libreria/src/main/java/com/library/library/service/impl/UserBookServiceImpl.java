package com.library.library.service.impl;

import com.library.library.dto.UserBookDTO;
import com.library.library.entity.BookEntity;
import com.library.library.entity.UserBookEntity;
import com.library.library.entity.UserEntity;
import com.library.library.mapper.UserBookMapper;
import com.library.library.repository.BookRepository;
import com.library.library.repository.UserBookRepository;
import com.library.library.repository.UserRepository;
import com.library.library.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    private UserBookRepository userBookRepository;
    @Autowired
    private UserBookMapper userBookMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void addBook(Long idUser, Long idBook, UserBookDTO dto){
        UserEntity user = userRepository.getReferenceById(idUser);
        BookEntity book = bookRepository.getReferenceById(idBook);
        UserBookEntity lending = userBookMapper.usboDTO2Entity(dto, user, book);
        userBookRepository.save(lending);
    }

}

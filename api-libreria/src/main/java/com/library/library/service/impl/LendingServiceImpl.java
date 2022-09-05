package com.library.library.service.impl;

import com.library.library.dto.LendingDTO;
import com.library.library.entity.BookEntity;
import com.library.library.entity.LendingEntity;
import com.library.library.entity.UserEntity;
import com.library.library.mapper.LendingMapper;
import com.library.library.repository.BookRepository;
import com.library.library.repository.LendingRepository;
import com.library.library.repository.UserRepository;
import com.library.library.service.BookService;
import com.library.library.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LendingServiceImpl implements LendingService {
    @Autowired
    private LendingRepository lendingRepository;
    @Autowired
    private LendingMapper lendingMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    public void addReserve(Long idUser, Long idBook, LendingDTO dto){
        UserEntity user = userRepository.getReferenceById(idUser);
        BookEntity book = bookRepository.getReferenceById(idBook);
        LendingEntity lending = lendingMapper.usboDTO2Entity(dto, user, book);
        lendingRepository.save(lending);
    }
    public void delete(Long idLending) {
    lendingRepository.deleteById(idLending);
    }
    public void returnLending(Long idLending){
        if (!existLending(idLending)){
            throw new RuntimeException("Doesn't exists this lending.");
        }
        LendingEntity entity = lendingRepository.getReferenceById(idLending);
        BookEntity book = bookRepository.getReferenceById(entity.getBookId());
        bookService.returnUnit(book.getId());
        bookRepository.save(book);
        lendingRepository.save(entity);
    }
    public Boolean existLending(Long idLending){
        return lendingRepository.existsById(idLending)?true:false;
    }
}

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
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    public void addReserve(Long idUser, Long idBook, LendingDTO dto){
        UserEntity user = userRepository.getReferenceById(idUser);
        BookEntity book = bookRepository.getReferenceById(idBook);
        LendingEntity lending = lendingMapper.usboDTO2Entity(dto, user, book);
        lendingRepository.save(lending);
    }
    public void delete(Long idLending) {
    lendingRepository.deleteById(idLending);
    }
    public void returnLending(Long idLending, Boolean lostBook){
        if (!existLending(idLending)){
            throw new RuntimeException("Doesn't exists this lending.");
        }else{
            LendingEntity entity = lendingRepository.getReferenceById(idLending);
            BookEntity book = bookRepository.getReferenceById(entity.getBookId());
            if(!entity.getDeleted()) {
                if (lostBook) {
                    if (book.getLost() < book.getStock()) {
                        bookService.lostUnit(book.getId());
                    } else {
                        throw new RuntimeException("Complete Stock.");
                    }
                } else {
                    if(book.getAvailable() < book.getStock()){
                        bookService.returnUnit(book.getId());
                    }else{
                        throw new RuntimeException("Complete Stock.");
                    }
                }
                bookRepository.save(book);
                lendingRepository.save(entity);
            }else{
                throw new RuntimeException("Lending ended.");
            }
        }
    }
    public void renovation(Long idLending) {
        if(existLending(idLending)){
            LendingEntity entity = lendingRepository.getReferenceById(idLending);
            BookEntity book = bookRepository.getReferenceById(entity.getBookId());
            if (entity.getDeleted() && book.getAvailable()> 0 && book.getAvailable()<=book.getStock()) {
                entity.setDeleted(false);
                book.setAvailable(book.getAvailable()-1);
                book.setRenovation(book.getRenovation()+1);
                bookRepository.save(book);
                lendingRepository.save(entity);
            } else {
                throw new RuntimeException("The lending is still available or book's stock is empty.");
            }
        }else{
            throw new RuntimeException("You never reserved this book.");
        }
    }
    public Boolean existLending(Long idLending){
        return lendingRepository.existsById(idLending)?true:false;
    }
}

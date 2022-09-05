package com.library.library.service;

import com.library.library.dto.LendingDTO;
public interface LendingService {
    void addReserve(Long idUser, Long idBook, LendingDTO dto);
    void delete(Long idLending);
    void returnLending(Long idLending);
}

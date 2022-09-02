package com.library.library.dto;

import com.library.library.entity.BookEntity;
import com.library.library.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class UserBookDTO {
    private LocalDate dateOut;
    private LocalDate dateReturn;
    private Boolean deleted;
    //private UserEntity user;
    //private BookEntity book;
    private Long userId;
    private Long bookId;
}

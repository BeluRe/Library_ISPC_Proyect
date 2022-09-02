package com.library.library.mapper;

import com.library.library.dto.UserBookDTO;
import com.library.library.entity.BookEntity;
import com.library.library.entity.UserBookEntity;
import com.library.library.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserBookMapper {
    public UserBookEntity usboDTO2Entity(UserBookDTO dto, UserEntity user, BookEntity book){
        UserBookEntity entity = new UserBookEntity();
        entity.setDateOut(dto.getDateOut());
        entity.setDateReturn(dto.getDateReturn());
        entity.setDeleted(dto.getDeleted());
        entity.setUserId(user.getId());
        entity.setBookId(book.getId());
        return entity;
    }
}

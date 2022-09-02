package com.library.library.mapper;

import com.library.library.dto.BookDTO;
import com.library.library.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookEntity bookDTO2Entity(BookDTO dto){
        BookEntity entity = new BookEntity();
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setAuthor(dto.getAuthor());
        entity.setCategory(dto.getCategory());
        entity.setEdit(dto.getEdit());
        entity.setLang(dto.getLang());
        entity.setPages(dto.getPages());
        entity.setDescription(dto.getDescription());
        entity.setCopy(dto.getCopy());
        entity.setStock(dto.getStock());
        entity.setAvailable(dto.getAvailable());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
    public BookDTO bookEntity2DTO(BookEntity entity){
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDate(entity.getDate());
        dto.setAuthor(entity.getAuthor());
        dto.setCategory(entity.getCategory());
        dto.setEdit(entity.getEdit());
        dto.setLang(entity.getLang());
        dto.setPages(entity.getPages());
        dto.setDescription(entity.getDescription());
        dto.setCopy(entity.getCopy());
        dto.setStock(entity.getStock());
        dto.setAvailable(entity.getAvailable());
        dto.setDeleted(entity.getDeleted());
        return dto;
    }
    public BookEntity update(BookEntity entity, BookDTO dto){
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setAuthor(dto.getAuthor());
        entity.setCategory(dto.getCategory());
        entity.setEdit(dto.getEdit());
        entity.setLang(dto.getLang());
        entity.setPages(dto.getPages());
        entity.setDescription(dto.getDescription());
        entity.setCopy(dto.getCopy());
        entity.setStock(dto.getStock());
        entity.setAvailable(dto.getAvailable());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
}

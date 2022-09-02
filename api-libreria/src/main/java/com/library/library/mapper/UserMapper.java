package com.library.library.mapper;

import com.library.library.dto.UserDTO;
import com.library.library.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity userDTO2Entity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setTel(dto.getTel());
        entity.setAddress(dto.getAddress());
        entity.setFault(dto.getFault());
        entity.setPriceFault(dto.getPriceFault());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
    public UserDTO userEntity2DTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastname(entity.getLastname());
        dto.setTel(entity.getTel());
        dto.setAddress(entity.getAddress());
        dto.setFault(entity.getFault());
        dto.setPriceFault(entity.getPriceFault());
        dto.setDeleted(entity.getDeleted());
        return dto;
    }
    public UserEntity update(UserEntity entity, UserDTO dto){
        entity.getId();
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setTel(dto.getTel());
        entity.setAddress(dto.getAddress());
        entity.setFault(dto.getFault());
        entity.setPriceFault(dto.getPriceFault());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
}

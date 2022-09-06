package com.library.library.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private String tel;
    private Integer fault;
    private Integer priceFault;
    private Boolean deleted;
    private List<LendingBasicDTO> lendings;
}


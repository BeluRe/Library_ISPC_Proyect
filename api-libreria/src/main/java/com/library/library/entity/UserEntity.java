package com.library.library.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "user")
@Getter
@Setter
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id = ? ")
@Where(clause = "deleted = false")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastname;
    private String address;
    private String tel;
    private Integer fault;
    @Column(name = "price_fault")
    private Integer priceFault;
    private Boolean deleted;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<LendingEntity> lendings = new ArrayList<>();
}

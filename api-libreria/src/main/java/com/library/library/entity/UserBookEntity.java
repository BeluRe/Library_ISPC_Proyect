package com.library.library.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="user_book")
@Getter
@Setter
@SQLDelete(sql = "UPDATE user_book SET deleted = true WHERE id = ? ")
@Where(clause = "deleted=false")
@IdClass(UserBookEntity.class)
public class UserBookEntity implements Serializable {
    @Column(name = "date_out")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOut;
    @Column(name = "date_return")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateReturn;
    private Boolean deleted;
    @Id
    private Long userId;
    @Id
    private Long bookId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "id" ,insertable = false, updatable = false)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bookId", referencedColumnName = "id", insertable = false, updatable = false)
    private BookEntity book;

}

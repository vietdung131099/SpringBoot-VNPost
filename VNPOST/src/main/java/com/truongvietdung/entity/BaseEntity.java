package com.truongvietdung.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class}) // cơ chế JPA auditing
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreatedBy
    @Column
    private String createdBy;
    @CreatedDate
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING) // cái này là gì ???
    private LocalDate createdDate;
    @LastModifiedBy
    @Column(insertable = false)
    private String modifiedBy;
    @LastModifiedDate
    @Column(insertable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String modifiedDate;

}

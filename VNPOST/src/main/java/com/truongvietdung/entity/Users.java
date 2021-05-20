package com.truongvietdung.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Users extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private String phone;
    @Column(columnDefinition = "NVARCHAR(50)")
    private String address;
    @Column(columnDefinition = "NVARCHAR(80)")
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission",
               joinColumns = @JoinColumn(name = "users_id",nullable = false),
               inverseJoinColumns = @JoinColumn(name = "role_group_id",nullable = false))
    @JsonIgnore  //cái annotation này khi trả về client thì sẽ ko trả ra
    List<RoleGroup> roleGroups = new ArrayList<>();

}

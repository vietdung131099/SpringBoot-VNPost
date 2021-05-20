package com.truongvietdung.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class RoleGroup extends BaseEntity{

    @Column(columnDefinition = "NVARCHAR(100)")
    private String name;
    @Column(columnDefinition = "NTEXT")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "function_role_group",
               joinColumns = @JoinColumn(name = "role_group_id",nullable = false),
               inverseJoinColumns = @JoinColumn(name = "role_id",nullable = false))
    @JsonIgnore
    List<Role> roles = new ArrayList<>();


    @ManyToMany(mappedBy = "roleGroups")
    List<Users> users = new ArrayList<>();
}

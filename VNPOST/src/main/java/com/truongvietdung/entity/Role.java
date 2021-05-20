package com.truongvietdung.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Role extends BaseEntity{

    @Column(columnDefinition = "NVARCHAR(100)")
    private String name;
    @Column(columnDefinition = "NTEXT")
    private String description;

    @ManyToMany(mappedBy = "roles")
    List<RoleGroup> roleGroups = new ArrayList<>();

}

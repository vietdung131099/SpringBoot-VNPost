package com.truongvietdung.repository;

import com.truongvietdung.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findAllByIdIn(List<Integer> roleId);
}

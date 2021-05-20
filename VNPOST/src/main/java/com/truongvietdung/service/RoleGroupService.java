package com.truongvietdung.service;

import com.truongvietdung.entity.RoleGroup;
import com.truongvietdung.model.request.roleGroup.RoleGroupSaveRequest;
import com.truongvietdung.model.request.roleGroup.RoleGroupUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoleGroupService {
    void save(RoleGroupSaveRequest roleGroupSaveRequest);

    void edit(RoleGroupUpdateRequest roleGroupUpdateRequest);

    void deleteBatch(List<Integer> ids);

    List<RoleGroup> findAll();

    Page<RoleGroup> findAll(Pageable pageable);

    Optional<RoleGroup> findOneById(int id);

    List<RoleGroup> searchRoleGroups(String name);
}

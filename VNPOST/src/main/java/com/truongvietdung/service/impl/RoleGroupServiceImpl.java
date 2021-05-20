package com.truongvietdung.service.impl;

import com.truongvietdung.entity.Role;
import com.truongvietdung.entity.RoleGroup;
import com.truongvietdung.mapper.RoleGroupMapper;
import com.truongvietdung.model.request.roleGroup.RoleGroupSaveRequest;
import com.truongvietdung.model.request.roleGroup.RoleGroupUpdateRequest;
import com.truongvietdung.repository.RoleGroupRepository;
import com.truongvietdung.repository.RoleRepository;
import com.truongvietdung.service.RoleGroupService;
import com.truongvietdung.validate.RoleGroupValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleGroupServiceImpl implements RoleGroupService {

    @Autowired
    private RoleGroupRepository roleGroupRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleGroupMapper roleGroupMapper;

    @Override
    public void save(RoleGroupSaveRequest roleGroupSaveRequest) {
        RoleGroupSaveRequest roleGroupSaveRequest1 = RoleGroupValidate.validateObjectSave(roleGroupSaveRequest);
        RoleGroup roleGroup = roleGroupMapper.convertSave(roleGroupSaveRequest1);
        List<Role> roles = roleRepository.findAllByIdIn(roleGroupSaveRequest1.getRoleId());
        roleGroup.setRoles(roles);
        roleGroupRepository.save(roleGroup);
    }

    @Override
    public void edit(RoleGroupUpdateRequest roleGroupUpdateRequest) {
        RoleGroupUpdateRequest roleGroupUpdateRequest1 = RoleGroupValidate.validateObjectSave(roleGroupUpdateRequest);
        RoleGroup roleGroup = roleGroupMapper.convertUpdate(roleGroupUpdateRequest1);
        List<Role> roles = roleRepository.findAllByIdIn(roleGroupUpdateRequest1.getRoleId());
        roleGroup.setRoles(roles);
        roleGroupRepository.save(roleGroup);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id : ids) {
            roleGroupRepository.deleteById(id);
        }
    }

    @Override
    public List<RoleGroup> findAll() {
        return roleGroupRepository.findAll();
    }

    @Override
    public Page<RoleGroup> findAll(Pageable pageable) {
        return roleGroupRepository.findAll(pageable);
    }

    @Override
    public Optional<RoleGroup> findOneById(int id) {
        return roleGroupRepository.findOneById(id);
    }

    @Override
    public List<RoleGroup> searchRoleGroups(String name) {
        return roleGroupRepository.searchRoleGroups(name);
    }
}

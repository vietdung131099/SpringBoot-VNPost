package com.truongvietdung.service.impl;

import com.truongvietdung.entity.RoleGroup;
import com.truongvietdung.entity.Users;
import com.truongvietdung.mapper.UserMapper;
import com.truongvietdung.mapper.UserMapperCustom;
import com.truongvietdung.model.request.user.UsersSaveRequest;
import com.truongvietdung.model.request.user.UsersUpdateRequest;
import com.truongvietdung.repository.RoleGroupRepository;
import com.truongvietdung.repository.UsersRepository;
import com.truongvietdung.service.UsersService;
import com.truongvietdung.validate.UsersValidate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleGroupRepository roleGroupRepository;
    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    @Override
    public Optional<Users> findOneById(int id) {
        return usersRepository.findOneById(id);
    }

    @Override
    public void save(UsersSaveRequest usersSaveRequest) {
        UsersSaveRequest usersSaveRequest1 = UsersValidate.validateObjectSave(usersSaveRequest);
        Users users = userMapperCustom.convertSave(usersSaveRequest1);
        List<RoleGroup> roleGroups = roleGroupRepository.findAllByIdIn(usersSaveRequest1.getRoleGroupIds());
        users.setRoleGroups(roleGroups);
        usersRepository.save(users);
    }

    @Override
    public void edit(UsersUpdateRequest usersUpdateRequest) {
        UsersUpdateRequest usersUpdateRequest1 = UsersValidate.validateObjectSave(usersUpdateRequest);
        Users users = userMapperCustom.convertUpdate(usersUpdateRequest1);
        List<RoleGroup> roleGroups = roleGroupRepository.findAllByIdIn(usersUpdateRequest1.getRoleGroupIds());
        users.setRoleGroups(roleGroups);
        usersRepository.save(users);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id : ids) {
            usersRepository.deleteById(id);
        }
    }

    @Override
    public List<Users> searchUsers(String userName) {
        return usersRepository.searchUsers(userName);
    }
}

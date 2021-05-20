package com.truongvietdung.service;

import com.truongvietdung.entity.Users;
import com.truongvietdung.model.request.user.UsersSaveRequest;
import com.truongvietdung.model.request.user.UsersUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Page<Users> findAll(Pageable pageable);

    Optional<Users> findOneById(int id);

    void save(UsersSaveRequest usersSaveRequest);

    void edit(UsersUpdateRequest usersUpdateRequest);

    void deleteBatch(List<Integer> ids);

    List<Users> searchUsers(String userName);
}

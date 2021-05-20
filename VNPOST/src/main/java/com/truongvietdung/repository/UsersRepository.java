package com.truongvietdung.repository;

import com.truongvietdung.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findByUserName(String userName);

    Optional<Users> findOneById(int id);

    @Query(value = "select u from Users u where u.userName like %?1%")
    List<Users> searchUsers(String userName);
}

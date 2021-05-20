package com.truongvietdung.controller.api;

import com.truongvietdung.entity.Users;
import com.truongvietdung.model.request.user.UsersSaveRequest;
import com.truongvietdung.model.request.user.UsersUpdateRequest;
import com.truongvietdung.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersApiController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<Void> addUsers(@RequestBody UsersSaveRequest usersSaveRequest){
        usersService.save(usersSaveRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users")
    public ResponseEntity<Void> editUsers(@RequestBody UsersUpdateRequest usersUpdateRequest){
        usersService.edit(usersUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUsers(@RequestBody List<Integer> ids){
        usersService.deleteBatch(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/searchUsers")
    public ResponseEntity<List<Users>> searchUsers(@RequestBody String data){
        List<Users> users = usersService.searchUsers(data);
        return ResponseEntity.ok(users);
    }
}

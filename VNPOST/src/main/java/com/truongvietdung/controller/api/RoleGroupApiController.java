package com.truongvietdung.controller.api;

import com.truongvietdung.entity.RoleGroup;
import com.truongvietdung.model.request.roleGroup.RoleGroupSaveRequest;
import com.truongvietdung.model.request.roleGroup.RoleGroupUpdateRequest;
import com.truongvietdung.service.RoleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleGroupApiController {

    @Autowired
    private RoleGroupService roleGroupService;

    @PostMapping("/roleGroup")
    public ResponseEntity<Void> addRoleGroup(@RequestBody RoleGroupSaveRequest roleGroupSaveRequest){
        roleGroupService.save(roleGroupSaveRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/roleGroup")
    public ResponseEntity<Void> editRoleGroup(@RequestBody RoleGroupUpdateRequest roleGroupUpdateRequest){
        roleGroupService.edit(roleGroupUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/roleGroup")
    public ResponseEntity<Void> deleteRoleGroup(@RequestBody List<Integer>ids){
        roleGroupService.deleteBatch(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/searchRoleGroups")
    public ResponseEntity<List<RoleGroup>> searchRoleGroups(@RequestBody String data){
        List<RoleGroup> roleGroups = roleGroupService.searchRoleGroups(data);
        return ResponseEntity.ok(roleGroups);
    }

}

package com.truongvietdung.controller.api;

import com.truongvietdung.entity.Blog;
import com.truongvietdung.entity.DetailService;
import com.truongvietdung.model.request.detailService.DetailServiceSaveRequest;
import com.truongvietdung.model.request.detailService.DetailServiceUpdateRequest;
import com.truongvietdung.service.DetailService_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetailServiceApiController {

    @Autowired
    private DetailService_Service detailService_service;

    @PostMapping("/detail-service")
    public ResponseEntity<Void> addDetailService(@RequestBody DetailServiceSaveRequest detailServiceSaveRequest){
        detailService_service.save(detailServiceSaveRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/detail-service")
    public ResponseEntity<Void> deleteDetailService(@RequestBody List<Integer> ids){
        detailService_service.delete(ids);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/detail-service")
    public ResponseEntity<Void> updateDetailService(@RequestBody DetailServiceUpdateRequest detailServiceUpdateRequest){
        detailService_service.update(detailServiceUpdateRequest);
        return ResponseEntity.ok().build();
    }

}

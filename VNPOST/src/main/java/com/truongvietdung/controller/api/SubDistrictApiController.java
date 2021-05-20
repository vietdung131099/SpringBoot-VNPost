package com.truongvietdung.controller.api;

import com.truongvietdung.model.request.subDistrict.SubDistrictSaveRequest;
import com.truongvietdung.model.request.subDistrict.SubDistrictUpdateRequest;
import com.truongvietdung.model.response.subDistrict.SubDistrictResponse;
import com.truongvietdung.service.SubDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubDistrictApiController {

    @Autowired
    private SubDistrictService subDistrictService;

    @PostMapping("/subDistrict")
    public ResponseEntity<Void> addSubDistrict(@RequestBody SubDistrictSaveRequest subDistrictSaveRequest){
        subDistrictService.save(subDistrictSaveRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/subDistrict")
    public ResponseEntity<Void> editSubDistrict(@RequestBody SubDistrictUpdateRequest subDistrictUpdateRequest){
        subDistrictService.edit(subDistrictUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/subDistrict")
    public ResponseEntity<Void> deleteSubDistrict(@RequestBody List<String> ids){
        subDistrictService.deleteBatch(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/searchSubDistricts")
    public ResponseEntity<List<SubDistrictResponse>> searchSubDistricts(@RequestBody String data) {
        List<SubDistrictResponse> subDistrictResponses = subDistrictService.searchSubDistricts(data);
        return ResponseEntity.ok(subDistrictResponses);
    }
}

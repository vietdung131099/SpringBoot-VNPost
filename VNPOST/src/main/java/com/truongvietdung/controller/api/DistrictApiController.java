package com.truongvietdung.controller.api;

import com.truongvietdung.entity.District;
import com.truongvietdung.model.request.district.DistrictSaveRequest;
import com.truongvietdung.model.request.district.DistrictUpdateRequest;
import com.truongvietdung.model.response.district.DistrictResponse;
import com.truongvietdung.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DistrictApiController {

    @Autowired
    private DistrictService districtService;

    @PostMapping("/district")
    public ResponseEntity<Void> addDistrict(@RequestBody DistrictSaveRequest districtSaveRequest) {
        districtService.save(districtSaveRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/district")
    public ResponseEntity<Void> editDistrict(@RequestBody DistrictUpdateRequest districtUpdateRequest) {
        districtService.edit(districtUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/district")
    public ResponseEntity<Void> deleteDistrict(@RequestBody List<String> ids) {
        districtService.delete(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/showDistrict")
    public ResponseEntity<List<District>> showDistrictSelected(@RequestBody String id) {
        List<District> districts = districtService.findAllByCityId(id);
        return ResponseEntity.ok(districts);
    }

    @PostMapping("/searchDistricts")
    public ResponseEntity<List<DistrictResponse>> searchDistricts(@RequestBody String data) {
        List<DistrictResponse> districts = districtService.searchDistricts(data);
        return ResponseEntity.ok(districts);
    }

}

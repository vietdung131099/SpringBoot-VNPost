package com.truongvietdung.controller.api;

import com.truongvietdung.entity.District;
import com.truongvietdung.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class showProvinceApiController {

    @Autowired
    private DistrictService districtService;


    @PostMapping(value = "/province",produces = "application/json")
    public ResponseEntity<List<District>> showDistrict(@RequestBody String city_id){
        List<District> districts = districtService.findAllByCityId(city_id);
        return ResponseEntity.ok(districts);
    }


}

package com.truongvietdung.controller.api;

import com.truongvietdung.entity.City;
import com.truongvietdung.model.request.city.CitySaveRequest;
import com.truongvietdung.model.request.city.CityUpdateRequest;
import com.truongvietdung.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityApiController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<Void> addCity(@RequestBody CitySaveRequest citySaveRequest){
        cityService.save(citySaveRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/city")
    public ResponseEntity<Void> editCity(@RequestBody CityUpdateRequest cityUpdateRequest){
        cityService.edit(cityUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/city")
    public ResponseEntity<Void> deleteCity(@RequestBody List<String> ids){
        cityService.deleteBatch(ids);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/searchCities")
    public ResponseEntity<List<City>> searchCities(@RequestBody String data){
        List<City> cities = cityService.searchCities(data);
        return ResponseEntity.ok(cities);
    }
}

package com.truongvietdung.repository;

import com.truongvietdung.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, String> {
    Optional<City> findOneById(String id);

    @Query(value = "select c from City c where c.name like %?1%")
    List<City> searchCities(String name);
}

package com.truongvietdung.repository;

import com.truongvietdung.entity.District;
import com.truongvietdung.model.response.district.DistrictResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District,String> {

    @Query(value = "SELECT d  from District  d WHERE d.city.id = ?1")
    List<District> findAllByCityId(String cityId);

    @Query(value = "SELECT new com.truongvietdung.model.response.district.DistrictResponse(d.id,d.name,d.nameEnglish,d.level,c.name) " +
            "FROM District d INNER JOIN City c ON c.id = d.city.id")
    Page<DistrictResponse> findDetailDistrict(Pageable pageable);

    Optional<District> findOneById(String id);

    @Query(value = "SELECT new com.truongvietdung.model.response.district.DistrictResponse(d.id,d.name,d.nameEnglish,d.level,c.name) " +
            "FROM District d INNER JOIN City c ON c.id = d.city.id where d.name like %?1%")
    List<DistrictResponse> searchDistricts(String name);
}

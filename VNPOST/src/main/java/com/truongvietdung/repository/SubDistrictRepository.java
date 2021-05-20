package com.truongvietdung.repository;

import com.truongvietdung.entity.SubDistrict;
import com.truongvietdung.model.response.subDistrict.SubDistrictResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubDistrictRepository extends JpaRepository<SubDistrict,String> {

    @Query(value = "SELECT new com.truongvietdung.model.response.subDistrict.SubDistrictResponse(s.id,s.name,s.nameEnglish,s.level,c.name,d.name)" +
            "FROM SubDistrict s INNER JOIN District d ON s.district.id = d.id INNER JOIN City c ON c.id = d.city.id")
    List<SubDistrictResponse> findAllDetailSubDistrict(Pageable pageable);

    Optional<SubDistrict> findOneById(String id);

    @Query(value = "SELECT new com.truongvietdung.model.response.subDistrict.SubDistrictResponse(s.id,s.name,s.nameEnglish,s.level,c.name,d.name)" +
            "FROM SubDistrict s INNER JOIN District d ON s.district.id = d.id INNER JOIN City c ON c.id = d.city.id WHERE s.name LIKE %?1%")
    List<SubDistrictResponse> searchSubDistricts(String name);
}

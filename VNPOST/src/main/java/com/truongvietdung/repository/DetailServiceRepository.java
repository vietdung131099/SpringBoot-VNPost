package com.truongvietdung.repository;

import com.truongvietdung.entity.DetailService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DetailServiceRepository extends JpaRepository<DetailService,Integer> {
    Optional<DetailService> findOneById(int id);

    List<DetailService> findAllByServiceCompanyId(int id, Pageable pageable);

}

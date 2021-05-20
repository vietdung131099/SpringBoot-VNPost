package com.truongvietdung.repository;

import com.truongvietdung.entity.ServiceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceCompanyRepository extends JpaRepository<ServiceCompany,Integer> {

    Optional<ServiceCompany> findOneById(int id);
}

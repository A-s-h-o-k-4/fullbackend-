package com.practice.rolesecurity.repository;

import com.practice.rolesecurity.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity,Long> {
    List<RegisterEntity> findByEmail(String email);
}

package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Entityclass;
@Repository
public interface userRapo extends JpaRepository<Entityclass, String> {

}

package com.example.TestingAPI.dao;

import com.example.TestingAPI.vo.Bbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RestAPIRepository extends JpaRepository<Bbs, Integer> {

}

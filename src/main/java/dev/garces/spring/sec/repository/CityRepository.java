package dev.garces.spring.sec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.garces.spring.sec.model.City;
import dev.garces.spring.sec.model.Department;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityName(String cityName);
    @Query("SELECT c FROM City c WHERE c.department = :department")
    List<City> findByDepartment(@Param("department") Department department);
} 


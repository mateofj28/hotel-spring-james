package dev.garces.spring.sec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.garces.spring.sec.model.Country;
import dev.garces.spring.sec.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByDepartmentName(String departmentName);
    
    @Query("SELECT d FROM Department d WHERE d.country = :country")
    List<Department> findByCountry(@Param("country") Country country);
}

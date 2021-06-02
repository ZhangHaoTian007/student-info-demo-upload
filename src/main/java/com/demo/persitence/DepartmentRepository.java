package com.demo.persitence;

import com.demo.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 32050
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {
}

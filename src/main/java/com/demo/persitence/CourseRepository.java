package com.demo.persitence;

import com.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 32050
 */
public interface CourseRepository extends JpaRepository<Course, String> {

}

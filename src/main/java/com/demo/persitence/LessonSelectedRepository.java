package com.demo.persitence;

import com.demo.domain.LessonSelected;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 32050
 */
public interface LessonSelectedRepository extends JpaRepository<LessonSelected, String> {
}

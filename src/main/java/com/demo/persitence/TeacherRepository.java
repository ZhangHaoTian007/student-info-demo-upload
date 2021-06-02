package com.demo.persitence;

import com.demo.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 32050
 */
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    /**
     * 通过教师Code查找教师信息
     * @param code 教师主码
     * @return 返回教师信息，如果没找到则返回null
     */
    Teacher findByCode(String code);
}

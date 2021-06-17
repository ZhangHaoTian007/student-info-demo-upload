package com.demo.service;

import com.demo.domain.Department;
import com.demo.persitence.*;
import com.demo.util.JSONResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 32050
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final LessonSelectedRepository lessonSelectedRepository;
    private final TeacherRepository teacherRepository;

    public DepartmentServiceImpl(TeacherRepository teacherRepository, LessonSelectedRepository lessonSelectedRepository, DepartmentRepository departmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.lessonSelectedRepository = lessonSelectedRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public JSONResult<Department> save(Department department) {
        Department d = this.departmentRepository.save(department);
        return new JSONResult<>(200, "成功插入/修改院系信息", d);
    }

    @Override
    public JSONResult<List<Department>> getAllDepartment(int page, int size) {
        Page<Department> departments = this.departmentRepository.findAll(PageRequest.of(page, size));
        return new JSONResult<>(200, "获取院系信息成功", departments.getContent());
    }

    @Override
    public JSONResult<Department> del(String code) {
        Department department = this.departmentRepository.findByCode(code);
        if (department == null) {
            return new JSONResult<>(403, "院系信息不存在", null);
        }
        this.departmentRepository.deleteByCode(code);
        // 删除教师信息
        this.teacherRepository.deleteAllByDepartment(department.getCode());
        // 删除学生信息
        this.studentRepository.deleteAllByMajorDepartment(department.getCode());
        // 删除选课信息
        this.lessonSelectedRepository.deleteAllByDepartment(department.getCode());
        return new JSONResult<>(200, "删除院系信息成功", department);
    }

    @Override
    public JSONResult<Long> countAll() {
        Long count = this.departmentRepository.count();
        return new JSONResult<>(200, "成功获取院系数量", count);
    }

}

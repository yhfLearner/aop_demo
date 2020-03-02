package com.hwua.service.impl;

import com.hwua.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void saveStudent() throws Exception {
        System.out.println("保存学生");

    }

    @Override
    public int deleteStudent(Integer id) throws Exception {
        System.out.println("删除学生");
        return 1;
    }

    @Override
    public void updateStudent() throws Exception {
        System.out.println("更新学生");

    }

    @Override
    public void findStudentById(Integer id) throws Exception {
        System.out.println("查询学生");

    }
}

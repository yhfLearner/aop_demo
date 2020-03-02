package com.hwua.test;

import com.hwua.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void test1() throws Exception {
        /*studentService.saveStudent();
        studentService.deleteStudent(1);
        studentService.updateStudent();*/
        studentService.findStudentById(1);
    }
}

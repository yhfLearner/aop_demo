package com.hwua.service;

public interface StudentService {
    public void saveStudent() throws Exception;

    public int deleteStudent(Integer id) throws Exception;

    public void updateStudent() throws Exception;

    public void findStudentById(Integer id) throws Exception;

}

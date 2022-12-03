package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //1
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    //2
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    //3
    public void addStudentTeacherPair(String student , String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
    }
    //4
    public Student getStudentByName(String student){
       return studentRepository.getStudentByName(student);
    }
    //5
    public Teacher getTeacherByName(String teacher){
        return studentRepository.getTeacherByName(teacher);
    }
    //6
    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsByTeacherName(teacher);
    }
    //7
    public List<String>getAllStudents(){
        return studentRepository.getAllStudents();
    }
    //8
    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }
    //9
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}

package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student>studentMap = new HashMap<>();
    HashMap<String,Teacher>teacherMap = new HashMap<>();
    HashMap<String,List<String>>teacherStudentMap = new HashMap<>();

    //1
    public void addStudent(Student student){
        studentMap.put(student.getName(),student);
    }
    //2
    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    //3
    public void addStudentTeacherPair(String student,String teacher){
        if(teacherStudentMap.containsKey(teacher)){
            List<String>ans = teacherStudentMap.get(teacher);
            ans.add(student);
            teacherStudentMap.put(teacher,ans);
        }
        else {
            List<String>ans = new ArrayList<>();
            ans.add(student);
            teacherStudentMap.put(teacher,ans);
        }
    }
    //4
    public Student getStudentByName(String student){
        return studentMap.get(student);
    }
    //5
    public Teacher getTeacherByName(String teacher){
        return teacherMap.get(teacher);
    }
    //6
    public List<String> getStudentsByTeacherName(String teacher){
        return teacherStudentMap.get(teacher);
    }
    //7
    public List<String>getAllStudents(){
        List<String>ans = new ArrayList<>();
        for(String student:studentMap.keySet()){
            ans.add(student);
        }
        return ans;
    }
    //8
    public void deleteTeacherByName(String teacher){
        List<String> temp = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)){
            temp = teacherStudentMap.get(teacher);
            teacherStudentMap.remove(teacher);
            for(String student : temp){
                if (studentMap.containsKey(student)) {
                    studentMap.remove(student);
                }
            }
        }
        if (teacherMap.containsKey(teacher))teacherMap.remove(teacher);
    }
    //9
    public void deleteAllTeachers(){
        List<String>temp = new ArrayList<>();
        for(String teacher:teacherStudentMap.keySet()){
            temp.add(teacher);
        }
        for(String teacher:temp){
            deleteTeacherByName(teacher);
        }
    }
}

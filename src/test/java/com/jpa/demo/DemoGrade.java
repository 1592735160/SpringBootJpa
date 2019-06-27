package com.jpa.demo;

import com.jpa.demo.dao.GradeDao;
import com.jpa.demo.dao.StudentDao;
import com.jpa.demo.entity.Grade;
import com.jpa.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoGrade {

    @Autowired
    private GradeDao gradeDao;

    @Test
    public void gradeInfos(){
        Grade grade = gradeDao.findById(1).get();
        List<Student> list = grade.getStudents();
        for (Student student : list) {
            System.out.println(student.getId()+" -- "+student.getName());
        }
    }
}

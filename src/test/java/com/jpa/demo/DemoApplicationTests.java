package com.jpa.demo;

import com.jpa.demo.dao.StudentDao;
import com.jpa.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StudentDao studentDao;

    // 增加student
    @Test
    public void updateStudentTest() {
        Student student = new Student();
        student.setName("万");
        student.setAge("19");
        student.setSex("男");
        Student stu = studentDao.save(student);
        System.out.println(stu.getId());
    }

    // 根据Id删除
    @Test
    public void deleteById(){
        studentDao.deleteById((long)12);
    }

    // 查询全部信息
    @Test
    public void studentInfos(){
        List<Student> all = studentDao.findAll();
        for (Student student : all) {
//            System.out.println(student.getId());
            System.out.println(student.getGrades().getGId()+" -- "+student.getGrades().getGName());
        }
    }

    // 根据Id查询信息
    @Test
    public void studentById(){
        Student student = studentDao.findById((long) 2).get();
        System.out.println(student.getName());
    }
    // 根据名字查询信息
    @Test
    public void studentByName(){
        List<Student> students = studentDao.studentByName("万");
        for (Student student : students) {
            System.out.println(student.getId()+"--"+student.getName());
        }
    }

    // 根据名字和Id
    @Test
    public void studentByNameAndById(){
        Student student = studentDao.findByNameAndId("万", 14);
        System.out.println(student.getId()+"--"+student.getName());
    }

    // SQL 根据Id查询信息
    @Test
    public void studentByIds(){
        Student student = studentDao.studentById(14);
        System.out.println(student.getId()+" -- "+student.getName());
    }

    // 修改信息
    @Test
    public void TestUpdate(){
        Student student = studentDao.findById((long) 2).get();
        student.setName("常某");
        studentDao.save(student);
        System.out.println(student.getId()+" -- "+student.getName());
    }


}

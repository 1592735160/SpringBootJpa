package com.jpa.demo.controller;

import com.jpa.demo.dao.StudentDao;
import com.jpa.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    // 查询全部
    @RequestMapping("/studentInfos")
    public List<Student> studentInfos(){
        return studentDao.findAll();
    }

    // 根据Id查询
    @RequestMapping("/studentById")
    public Optional<Student> studentById(){
        return studentDao.findById((long)2);
    }

    // 根据Id删除
    @RequestMapping("/deleteById")
    public void deleteById(){
        studentDao.deleteById((long)1);
    }


}

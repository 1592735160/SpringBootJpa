package com.jpa.demo.dao;

import com.jpa.demo.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Long> {

    // (固定写法)根据名字查询
    public List<Student> findByName(String name);

    //(固定写法)根据名字和Id
    public Student findByNameAndId(String name,long id);

    //(自定义 JPQL)根据名字模糊查询
    @Query(value = "select s from Student s where s.name=:name")
    public List<Student> studentByName(@Param("name") String name);

    //(自定义 SQL)根据名字模糊查询
    @Query(value = "select * from student where id=:id",nativeQuery = true)
    public Student studentById(@Param("id")long id);
}

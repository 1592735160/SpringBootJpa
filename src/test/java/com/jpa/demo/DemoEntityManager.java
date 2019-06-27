package com.jpa.demo;


import com.jpa.demo.dao.StudentDao;
import com.jpa.demo.entity.Grade;
import com.jpa.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoEntityManager {

    @PersistenceContext
    private EntityManager em;

    // 动态创建表
    @Test
    public void createTable(){
        Grade grade = new Grade();
//        grade.setgId(1);
        grade.setGName("S1");
        em.getTransaction().begin();
        em.merge(grade);
        em.getTransaction().commit();
//        em.close();
    }

    // 查询全部信息
    @Test
    public void students(){
        Query q = em.createQuery("from Student s order by s.id");
        q.setFirstResult(0);
        q.setMaxResults(3);
        List<Student> students = q.getResultList();
        for (Student student : students) {
            System.out.println(student.getId()+" -- "+student.getName());
        }
    }

    // 根据动态条件
    @Test
    public void studentInfo(){
        Student student = new Student();
        student.setName("吴");
//        student.setSex("男");
//        student = null;
        Map map = new LinkedHashMap();
        String JPQL = "select s from Student s where 1=1";
        if(student != null){
            if(student.getName() != null && !student.getName().equals("")){
                JPQL+=" and s.name like :name " ;
                map.put("name",student.getName());
            }
            if(student.getSex() != null && !student.getSex().equals("")){
                JPQL+=" and s.sex = :sex ";
                map.put("sex",student.getSex());
            }
        }

        Query query = em.createQuery(JPQL);
        if( map != null){
            Set<String> set = map.keySet();
            for (String key : set) {
                query.setParameter(key,map.get(key));
            }
        }
        List<Student> students = query.getResultList();
        for (Student s : students) {
            System.out.println(s.getId()+" -- "+s.getName());
        }
    }
}

package com.jpa.demo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gId;
    private String gName;

    @OneToMany(mappedBy = "grades",fetch = FetchType.LAZY)
    private List<Student> students;

}

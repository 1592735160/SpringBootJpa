package com.jpa.demo.entity;

import javafx.scene.control.Label;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String age;
  private String sex;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "grade_id")
  private Grade grades;


}

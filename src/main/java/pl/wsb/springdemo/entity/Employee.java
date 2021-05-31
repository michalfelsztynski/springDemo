package pl.wsb.springdemo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "Employee")
public class Employee extends BaseEntity {

  @Column(name = "Number")
  private Integer number;

  @Column(name = "Name")
  private String name;

  @Column(name = "Lastname")
  private String lastname;

  @ManyToOne(fetch = FetchType.LAZY)
  private Department department;

}

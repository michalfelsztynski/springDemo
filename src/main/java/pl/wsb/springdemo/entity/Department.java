package pl.wsb.springdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
public class Department extends BaseEntity {


  @Column(name = "Name")
  private String name;

  @Column(name = "Code")
  private String code;

  @OneToMany(
          mappedBy = "department",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Employee> employees = new ArrayList<>();

}

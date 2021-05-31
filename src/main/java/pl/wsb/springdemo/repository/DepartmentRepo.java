package pl.wsb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.springdemo.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}

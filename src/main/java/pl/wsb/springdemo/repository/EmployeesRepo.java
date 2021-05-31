package pl.wsb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wsb.springdemo.entity.Department;
import pl.wsb.springdemo.entity.Employee;

public interface EmployeesRepo extends JpaRepository<Employee, Long> {

    @Query(
            "select e from Employee e " +
            "where e.department= :dep"
    )
    Employee findByDepartment(@Param("dep") Department department);


    @Query(
            "select count (e) from Employee e " +
            "inner join Department d " +
            "where d.name= :name"
    )
    Long selectCountByDepartment(@Param("name") String name);
}

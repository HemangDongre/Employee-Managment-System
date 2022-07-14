package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Employee, Long> {
    //it implies, Repository has every thing you need to deal with data
    //say you need to add or update an employee, than you have the model(Employee),
    // which is nothing but the basic structure along with the primary key or uniqueness

}

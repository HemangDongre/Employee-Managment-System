package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFound;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin
public class empController {
    @Autowired
    private Repository repository;

    @GetMapping
    public List<Employee> getallEmpolyees() {
        return repository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
         return repository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findempBiID(@PathVariable long id){
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("check ID"));
        return ResponseEntity.ok(employee);
    }

    @PostMapping("{id}")
    public ResponseEntity<Employee> updateemp(@PathVariable long id, @RequestBody Employee employee){
        Employee newemployee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("please check ID"));
        newemployee.setFirst_name(employee.getFirst_name());
        newemployee.setSecond_name(employee.getSecond_name());

        repository.save(newemployee);
        return ResponseEntity.ok(newemployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmpByID(@PathVariable long id){
        Employee employee = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("CheckID"));
        repository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/0")
    public String home(){
        return ("<h1>Accessed by all </h1>");
    }

    @GetMapping("/role1")
    public String role1(){
        return ("<h1>Accessed by role1 </h1>");
    }

    @GetMapping("/role2")
    public String role2(){
        return ("<h1>Accessed by role2 </h1>");
    }
}

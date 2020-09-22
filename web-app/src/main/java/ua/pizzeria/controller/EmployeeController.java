package ua.pizzeria.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.pizzeria.database.model.Employee;
import ua.pizzeria.database.services.EmployeeService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public Collection<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Optional<Employee> group = Optional.ofNullable(employeeService.getById(id));
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/employee")
    ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) throws URISyntaxException {
        log.info("Request to create employee: {}", employee);
        Employee result = employeeService.add(employee);
        return ResponseEntity.created(new URI("/api/employee/" + result.getId()))
                .body(result);
    }

    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
        log.info("Request to update employee: {}", employee);
        Employee result = employeeService.add(employee);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        log.info("Request to delete employee: {}", id);
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

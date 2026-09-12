package com.azure.aks.api;

import com.azure.aks.model.Employee;
import com.azure.aks.request.EmployeeRequest;
import com.azure.aks.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController()
public class EmployeeApi {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAll() {

        Logger log = Logger.getLogger(this.getClass().getSimpleName());
        log.info("request for fetching all the employees");
        return employeeService.fetchAll(log);
    }



    @PostMapping("/employees/create")
    public ResponseEntity<String> create(@RequestBody EmployeeRequest request){

        employeeService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("employee created successfully");

    }

}

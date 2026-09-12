package com.azure.aks.service;


import com.azure.aks.model.Employee;
import com.azure.aks.request.EmployeeRequest;
import com.azure.aks.respository.EmployeeRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Service
public class EmployeeService {

    Gson gson;

    @PostConstruct
    public void init() {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();

    }

    GsonBuilder builder = new GsonBuilder();


    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> fetchAll(Logger log) {

        log.info("fetching all the employees from database");
        List<Employee> employees = employeeRepository.findAll();
        log.info("number of employees fetched: " + employees.size());
        return employees;
    }

    public boolean create(EmployeeRequest request) {

        log.info("creating employee");

        Employee employee = gson.fromJson(gson.toJson(request), Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);


        log.info("employee created with id " + savedEmployee.getId());
        return true;

    }
}



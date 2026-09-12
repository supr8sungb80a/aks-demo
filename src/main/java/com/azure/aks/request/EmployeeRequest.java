package com.azure.aks.request;

import com.azure.aks.model.Department;
import com.azure.aks.model.Level;
import lombok.Data;

@Data
public class EmployeeRequest {

    private String firstName;
    private String lastName;
    private String address;
    private String dateOfBirth;
    private String dateOfJoining;
    private String emailAddress;
    private Department department;
    private String designation;
    private Level level;

}

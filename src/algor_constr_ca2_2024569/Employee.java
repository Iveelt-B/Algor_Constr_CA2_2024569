/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algor_constr_ca2_2024569;

/**
 *
 * @author iveelteddie
 */
// Class to represent a employee with their details.
public class Employee {
    private String name;                // Name of the employee.
    private EmployeeType employeeType;  // Employee type of the employee.
    private ManagerType managerType;    // Manager type of the employee.
    private Department department;      // Department of the employee.
    private boolean isFromFile;         // Indicates if the employee is from the input file.
    
    // Constructor to initialize an Employee objectв
    public Employee (String name, EmployeeType employeeType, Department department, ManagerType managerType, boolean isFromFile) {
        this.name = name;                   // Set the employee's name.
        this.employeeType = employeeType;   // Set the employee's position.
        this.department = department;       // Set the department the employee belongs to.
        this.managerType = managerType;     // Set the type of manager supervising the employee.
        this.isFromFile = isFromFile;       // Indicate whether the employee data was loaded from a file.
    }
    // Getter for the employee's name.
    public String getName() { 
        return name;    // Return the employee's name.
    }
    // Getter for the employee type.
    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    // Getter for the manager type.
    public ManagerType getManagerType() {
        return managerType;
    }
    // Getter for the department.
    public Department getDepartment() {
        return department;
    }
    // Getter to check if the employee was loaded from a file.
    public boolean isFromFile() {
        return isFromFile;  // Return true if employee is from file, false otherwise.
    }
    // toString method to display employee details in a readable format.
    public String toString() {
        return "Name:" + name + ",  Employee Position:" + employeeType + ",  Department:" + department + ",  Manager Type:" 
                + managerType + ",  From file:" + (isFromFile ? " Yes" : " No (Newly added)");  // Format employee details.
    }
}

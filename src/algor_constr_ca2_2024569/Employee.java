/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algor_constr_ca2_2024569;

/**
 *
 * @author iveelteddie
 */
public class Employee {
    private String name;
    private int employeeID;
    private Department departmet;
    private EmployeeRole role;
    
    public Employee (String name, int employeedID, Department department, EmployeeRole role) {
        this.name = name;
        this.employeeID = employeeID;
        this.departmet = department;
        this.role = role;
    }
    
    public String getName() { 
        return name;
    }
    
    public int getEmployeeID() {
        return employeeID;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public EmployeeRole getRole() {
        return role;
    }
}

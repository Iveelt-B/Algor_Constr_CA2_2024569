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
    private EmployeeType employeeType;
    private ManagerType managerType;
    private Department department;
    private boolean isFromFile;
    
    public Employee (String name, EmployeeType employeeType, Department department, ManagerType managerType, boolean isFromFile) {
        this.name = name;
        this.employeeType = employeeType;      
        this.department = department;
        this.managerType = managerType;
        this.isFromFile = isFromFile; 
    }
    
    public String getName() { 
        return name;
    }
    
    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    
    public ManagerType getManagerType() {
        return managerType;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public boolean isFromFile() {
        return isFromFile;
    }
    
    public String toString() {
        return "Name:" + name + ",  Manager:" + managerType + ",  Department:" + department + ",  Job title:" 
                + employeeType + ",  From file:" + (isFromFile ? " Yes" : " No (Newly added)");
    }
}

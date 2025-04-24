/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algor_constr_ca2_2024569;

/**
 *
 * @author iveelteddie
 */
public class Manager extends Employee {
    private ManagerType managerType;
    
    public Manager(String name, int employeeID, Department department, EmployeeRole role, ManagerType managerType) {
        super(name, employeeID, department, role);
        this.managerType = managerType;
    }
    
    public ManagerType getManagerType() {
        return managerType;
    }
}

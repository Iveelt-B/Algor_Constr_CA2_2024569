/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algor_constr_ca2_2024569;

/**
 *
 * @author iveelteddie
 */
public class Department {
    private DepartmentType type;
    private int departmentID;
    private Manager manager;
    
    public Department(DepartmentType type, int departmentID) {
        this.type = type;
        this.departmentID = departmentID;
}
    
    public DepartmentType getType() {
        return type;
    }
    
    public int departmentID() {
        return departmentID;
    }
    
    public Manager getManager() {
        return manager;
    }
    
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
}

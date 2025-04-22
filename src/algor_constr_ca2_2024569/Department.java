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
    private String name;
    private int departmentID;
    private Manager manager;
    
    public Department(String name, int departmentID) {
        this.name = name;
        this.departmentID = departmentID;
    }
    
    public String getName() {
        return name;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
}

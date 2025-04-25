/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algor_constr_ca2_2024569;

import java.util.ArrayList;

/**
 *
 * @author iveelteddie
 */
public class Algor_Constr_CA2_2024569 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        private ArrayList<Employee> employees = new ArrayList<>();
        private ArrayList<Department> departments = new ArrayList<>();
        
        // Preparing 4 departments.
        public Algor_Constr_CA2_2024569() {
            departments.add(new Department(DepartmentType.IT, 1));
            departments.add(new Department(DepartmentType.HR, 2));
            departments.add(new Department(DepartmentType.MARKETING, 3));
            departments.add(new Department(DepartmentType.FINANCE, 4));
        }
        
        // Show the menu.
        public void displayMenu() {
            System.out.println("Please select an option:");
            System.out.println("1. Sort of all employees");
            System.out.println("2. Search for employees");
            System.out.println("3. Add Employee");
            System.out.println("4. Random Employee");
            System.out.println("5. Exit");
            
        }
    }
    
}

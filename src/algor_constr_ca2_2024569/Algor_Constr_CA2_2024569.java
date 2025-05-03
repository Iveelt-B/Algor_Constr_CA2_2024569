/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algor_constr_ca2_2024569;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author iveelteddie
 */
public class Algor_Constr_CA2_2024569 {

    /**
     * @param args the command line arguments
     */
    
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<String> allNames = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {
        loadFromFile();
        while (true) {
            showMenu();
            int choice = getValidChoice(MenuOption.values().length);
            handleMenuChoice(choice);
        }
    }
    
    public static void loadFromFile() {
        String filename = "/Users/iveelteddie/NetBeansProjects/Algor_Constr_CA2_2024569/src/algor_constr_ca2_2024569/Applicants_Form.txt";
        try (BufferedReader bufReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(","); 
                if (parts.length != 4) { 
                    System.out.println("Invalid line format: Incorrect format or Extra fields in line:  " + line);
                    continue; 
                }
                
                String name = parts[0].trim();
                String employeeTypeStr = parts[1].trim(); 
                String departmentStr = parts[2].trim(); 
                String managerTypeStr = parts[3].trim();
                
                if (name.isEmpty()) { 
                    System.out.println("Missing or Name is empty!:  " + line); 
                    continue; 
                }
                if (employeeTypeStr.isEmpty()) { 
                    System.out.println("Missing or EmployeeType is empty!:  " + line); 
                    continue; 
                }
                if (departmentStr.isEmpty()) { 
                    System.out.println("Missing or Department is empty!:    " + line); 
                    continue; 
                }
                if (managerTypeStr.isEmpty()) { 
                    System.out.println("Missing or ManagerType is empty!:   " + line); 
                    continue; 
                }
                
                try {
                    EmployeeType employeeType = EmployeeType.valueOf(employeeTypeStr); 
                    Department department = Department.valueOf(departmentStr); 
                    ManagerType managerType = ManagerType.valueOf(managerTypeStr); 
                    allNames.add(name); 
                    Employee employee = new Employee(name, employeeType, department, managerType, true); 
                    employees.add(employee); 
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid enum value for employeeType, Department, or ManagerType in line: " + line);
                    continue;
                }
            }
            System.out.println("\n*** File Read Successfully ***");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    // Show the menu.
    private static void showMenu() {
        System.out.println("\n--- Tech Company Management System ---");
        for (int n = 0; n < MenuOption.values().length; n++) {
            System.out.println((n + 1) + ". " + MenuOption.values()[n]);
        }
        System.out.println("Select an option: ");   // Ask the user for a choice.
    }
    
    // Get the user's choice.
    private static int getValidChoice(int max) {
        // Repeat until you get the correct choice.
        while (true) {  
            try {
                int choice = Integer.parseInt(scanner.nextLine());      // Read the selection.
                if (choice >= 1 && choice <= max) {  // If the selection is within the correct range.
                    return choice;  // Return the selection.
                }
                // Incorrect selection.
                System.out.println("Invalid choice. Please enter a number between 1 and " + max + ": ");
            } catch (NumberFormatException e) {     // If not a number. 
                System.out.println("Please enter a valid number: ");    // Enter for correct number input.
            }    
        }
    }
    
    // Take action based on menu selection. 
    private static void handleMenuChoice(int choice) {
        MenuOption option = MenuOption.values()[choice -1];
        switch (option) {
            case SORT:
                sortDisplayList();
                break;
            case SEARCH:
                searchEmployee();
                break;
            case ADD_EMPLOYEE:
                addNewEmployee();
                break;
            case CHOOSE_RANDOM_EMPLOYEES:
                randomEmployees();
                break;
            case EXIT:
                System.out.println("Exited the program.");
                System.exit(0); 
        }
    }
    
    // Sort the list and show the first 20 employees.
    private static void sortDisplayList() {
        if (employees.isEmpty()) {
            System.out.println("List is empty!\n");
            return;
        }
        SortingAlgorithm.insertionSort(employees);
        System.out.println("First 20 sorted people:\n");
        for (int e = 0; e < Math.min(20, employees.size()); e++) {
            System.out.println(employees.get(e));
        }
    }
    
    private static void searchEmployee() {
        if (employees.isEmpty()) {                  // If the list is empty.
            System.out.println("List is empty!");   // Print message.
            return;                                 // Exit the function.
        }
        System.out.println("Enter name to search: ");   // Enter for name input.
        String name = scanner.nextLine();               // Read the input name.
        SortingAlgorithm.insertionSort(employees);      // Sort the list before Binary Search.
        Employee found = SearchAlgorithm.binarySearchRecursive(employees, name);     // Call recursive Binary Search.
        if (found != null) {                            // If a employee is found.
            System.out.println("Found: " + found);      // Print the found employee's details.
        } else {                                        // If no employee is found.
            System.out.println("Employee not found!");  // Print message.
        }
    }
        
    
    private static void addNewEmployee() {
        System.out.print("Enter the name of the employee: ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) { 
            System.out.println("Name cannot be empty!"); 
            return; 
        }
        allNames.add(name); // Add name to allNames list
        
        System.out.println("--- Select Employee Position:");            // Enter to select employee type.
        for (EmployeeType empType : EmployeeType.values()) {        // Iterate through employee types.
            System.out.println((empType.ordinal() + 1) + ". " + empType); // Print each employee type.
        }
        int employeeChoice = getValidChoice(EmployeeType.values().length);     // Get valid employee type choice.
        EmployeeType employeeType = EmployeeType.values()[employeeChoice - 1]; // Retrieve selected employee type.
        
        
        System.out.println("--- Select Department: ");
        for (Department dept : Department.values()) {
            System.out.println(dept.ordinal() + 1 + "." + dept);
        }
        int departmentChoice = getValidChoice(Department.values().length);    // Get valid department choice.
        Department department = Department.values()[departmentChoice - 1];    // Retrieve selected department.
        
        
        System.out.println("--- Select Manager Type:");     // Enter to select manager type.
        for (ManagerType type : ManagerType.values()) { // Iterate through manager types.
            System.out.println((type.ordinal() + 1) + ". " + type); // Print each manager type.
        }
        int managerChoice = getValidChoice(ManagerType.values().length);   // Get valid manager type choice.
        ManagerType managerType = ManagerType.values()[managerChoice - 1]; // Retrieve selected manager type.
        
        Employee employee = new Employee(name, employeeType, department, managerType, false);
        employees.add(employee);
        System.out.println("** " + name + " has been added successfully! **");        // Confirm successful addition.
    }
    
    private static void randomEmployees() {
        
    }
   
}

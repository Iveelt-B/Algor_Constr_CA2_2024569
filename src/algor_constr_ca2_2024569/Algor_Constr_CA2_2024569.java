/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algor_constr_ca2_2024569;

import java.io.BufferedReader;  // Import BufferedReader for file reading.
import java.io.FileReader;      // Import FileReader for file reading.
import java.io.IOException;     // Import IOException for handling file errors.
import java.util.ArrayList;     // Import ArrayList class.
import java.util.HashSet;       // Import HashSet class for unique name selection.
import java.util.Random;        // Import Random class.
import java.util.Scanner;       // Import Scanner class.

/**
 *
 * @author iveelteddie
 */
public class Algor_Constr_CA2_2024569 {

    /**
     * @param args the command line arguments
     */
    
    private static ArrayList<Employee> employees = new ArrayList<>();           // Store the list of employees.
    private static ArrayList<String> allNames = new ArrayList<>();              // Store all names (from file and user input).
    private static ArrayList<Employee> newlyAddedEmployees = new ArrayList<>(); // Store newly added employees.
    private static Scanner scanner = new Scanner(System.in);                    // Scanner for user input.
    private static Random random = new Random();                                // Random for generating random data.
    
    // Main method to run the program.
    public static void main(String[] args) {
        loadFromFile();     // Load data from Applicants_Form.txt.
        while (true) {      // Main program loop.
            showMenu();     // Display the menu.
            int choice = getValidChoice(MenuOption.values().length);    // Get valid user choice.
            handleMenuChoice(choice);       // Handle the selected menu option.
        }
    }
    
    // Load data from Applicants_Form.txt file.
    public static void loadFromFile() {
        String filename = "/Users/iveelteddie/NetBeansProjects/Algor_Constr_CA2_2024569/src/algor_constr_ca2_2024569/Applicants_Form.txt";  // File name.
        try (BufferedReader bufReader = new BufferedReader(new FileReader(filename))) {     // Open file for reading.
            String line;    // Store each line.
            while ((line = bufReader.readLine()) != null) { // Read each line until end of file.
                line = line.trim();     // Remove leading trailing whitespace.
                if (line.isEmpty()) {   // Skip empty lines.
                    continue;           // Move to the next line.
                }
                String[] parts = line.split(",");   // Split line by comma. 
                if (parts.length != 4) {            // Check if line has exactly 4 fields.
                    System.out.println("Invalid line format: Incorrect format or Extra fields in line:  " + line);  // Print error for incorrect field count.
                    continue;   // Skip invalid line.
                }

                String name = parts[0].trim();              // Extract and trim name.
                String employeeTypeStr = parts[1].trim();   // Extract and trim employee type.
                String departmentStr = parts[2].trim();     // Extract and trim department.
                String managerTypeStr = parts[3].trim();    // Extract and trim manager type.
                
                if (name.isEmpty()) {   // Check if name is empty.
                    System.out.println("Missing or Name is empty!:  " + line);  // Print error for empty name.
                    continue;   // Skip line.
                }
                if (employeeTypeStr.isEmpty()) {    // Check if employeeType is empty.
                    System.out.println("Missing or EmployeeType is empty!:  " + line);  // Print error for empty employeeType.
                    continue;   // Skip line.
                }
                if (departmentStr.isEmpty()) {      // Check if department is empty.
                    System.out.println("Missing or Department is empty!:    " + line);  // Print error for empty department.
                    continue;   // Skip line.
                }
                if (managerTypeStr.isEmpty()) {     // Check if managerType is empty.
                    System.out.println("Missing or ManagerType is empty!:   " + line);  // Print error for empty managerType.
                    continue;   // Skip line.
                }
                
                try {
                    EmployeeType employeeType = EmployeeType.valueOf(employeeTypeStr);  // Parse employee type.
                    Department department = Department.valueOf(departmentStr);          // Parse department.
                    ManagerType managerType = ManagerType.valueOf(managerTypeStr);      // Parse manager type.
                    allNames.add(name);         // Add name to allNames list.
                    Employee employee = new Employee(name, employeeType, department, managerType, true);    // Create new employee.
                    employees.add(employee);    // Add employee to employees list.
                } catch (IllegalArgumentException e) {  // Handle invalid enum values.
                    System.out.println("Invalid enum value for employeeType, Department, or ManagerType in line: " + line); // Print error for invalid enum.
                    continue;   // Skip line.
                }
            }
            System.out.println("\n*** File Read Successfully ***");         // Confirm successful file reading.
        } catch (IOException e) {   // Handle file reading errors.
            System.out.println("Error reading file: " + e.getMessage());    // Print error message.
        }
    }
    
    // Show the menu options.
    private static void showMenu() {
        System.out.println("\n--- Tech Company Management System ---"); // Print system title.
        for (MenuOption option : MenuOption.values()) {     // Loop through menu options.
            System.out.println((option.ordinal() + 1) + ". " + option.name().replace("_", " "));    // Print each option.
        }
        System.out.println("Select an option: ");   // Ask the user for a choice.
    }
    
    // Validate and return user choice
    private static int getValidChoice(int max) {
        while (true) {  // Loop until a valid choice is received
            try {
                int choice = Integer.parseInt(scanner.nextLine());   // Read user input as integer.
                if (choice >= 1 && choice <= max) {  // Check if choice is within valid range.
                    return choice;  // Return valid choice.
                }
                System.out.println("Invalid choice. Please enter a number between 1 and " + max + ": ");    // Enter for valid input.
            } catch (NumberFormatException e) {     // Handle non-integer input
                System.out.println("Please enter a valid number: ");    // Enter for for valid number.
            }    
        }
    }
    
    // Handle the selected menu option. 
    private static void handleMenuChoice(int choice) {
        MenuOption option = MenuOption.values()[choice -1];     // Convert choice to MenuOption enum.
        switch (option) {       // Handle based on selected option.
            case SORT_EMPLOYEES:    // Sort the list.
                sortDisplayList();  // Call sort and display function.
                break;
            case SEARCH_BY_EMPLOYEE_NAME:   // Search for a employee.
                searchEmployee();           // Call search function.
                break;
            case ADD_EMPLOYEE:      // Add a new employee.
                addNewEmployee();   // Call add employee function.
                break;
            case CHOOSE_RANDOM_EMPLOYEES:   // Choose random employees.
                randomEmployees();          // Call random choose function.
                break;
            case EXIT:          // Exit the program.
                System.out.println("* Exited the program *");  // Print exit message.
                System.exit(0); 
        }
    }
    
    // Sort and display the first 20 employees.
    private static void sortDisplayList() {
        if (employees.isEmpty()) {                  // Check if the list is empty.
            System.out.println("List is empty!\n"); // Print empty list message.
            return;     // Exit the function.
        }
        SortingAlgorithm.insertionSort(employees);                  // Sort the list using recursive Insertion Sort.
        System.out.println("\n--- First 20 employees in alphabetical sort: ");      // Print for sorted list.
        for (int e = 0; e < Math.min(20, employees.size()); e++) {  // Loop through first 20 employees.
            System.out.println(employees.get(e));                   // Print each employee's details.
        }
    }
    
    // Search for a employee by name (supports partial name matching).
    private static void searchEmployee() {
        if (employees.isEmpty()) {                  // If the list is empty.
            System.out.println("List is empty!");   // Print empty list message.
            return;                                 // Exit the function.
        }
        System.out.println("Enter name to search: ");            // Enter for name input.
        String query = scanner.nextLine().trim().toLowerCase();  // Read and normalize the input name.
        if (query.isEmpty()) {   // Check if query is empty.
            System.out.println("Search name cannot be empty!");  // Print error message.
            return;     // Exit the function.
        }
        SortingAlgorithm.insertionSort(employees);      // Sort the list before Binary Search.
        boolean found = false;                          // to track if any matches are found.
        Employee exactMatch = SearchAlgorithm.binarySearchRecursive(employees, query);     // Call recursive Binary Search.
        if (exactMatch != null) {   // If an exact match is found.
            if (!found) {           // Print if results are found.
                System.out.println("\nSearch Results:");    // Print for search results.
            }
            System.out.println("Found: " + exactMatch);     // Print the exact match.
            found = true;   // Set found it.
        }
        
        // Search for partial matches by loop through the list.
        for (Employee employee : employees) {   // loop through all employees.
            String fullname = employee.getName().toLowerCase();     // Get employees name in lowercase.
            if (fullname.contains(query)) {      // Check if name contains query.
                if (exactMatch == null || !employee.getName().equalsIgnoreCase(exactMatch.getName())) {     // Avoid duplicating exact match.
                    if (!found){    // Print if results are found.
                        System.out.println("\n** Search Results **");    // Print header for search results.
                    }
                    System.out.println("Found: " + employee);   // Print partial match.
                    found = true;   // Set found it.
                }
            }
        }
        if (!found) {    // If no matches are found.
            System.out.println("Employee not found!");  // Print not found message.
        }
    }
        
    // Add a new employee to the system.
    private static void addNewEmployee() {
        System.out.print("Enter the name of the employee: ");   // Enter for name input.
        String name = scanner.nextLine();   // Read the input name.
        if (name.trim().isEmpty()) {        // Check if the name is empty.
            System.out.println("Name cannot be empty!");        // Print error message.
            return;     // Exit the function.
        }
        allNames.add(name); // Add name to allNames list
        
        System.out.println("--- Select Employee Position:");        // Enter to select employee type.
        for (EmployeeType empType : EmployeeType.values()) {        // Iterate through employee types.
            System.out.println((empType.ordinal() + 1) + ". " + empType); // Print each employee type with index.
        }
        int employeeChoice = getValidChoice(EmployeeType.values().length);     // Get valid employee type choice.
        EmployeeType employeeType = EmployeeType.values()[employeeChoice - 1]; // Retrieve selected employee type.
        System.out.println("Selected Employee Type: " + employeeType);         // Confirm selected employee type.
        
        
        System.out.println("--- Select Department: ");              // Enter to select department.
        for (Department dept : Department.values()) {               // Iterate through departments.
            System.out.println(dept.ordinal() + 1 + "." + dept);    // Print each department with index.
        }
        int departmentChoice = getValidChoice(Department.values().length);    // Get valid department choice.
        Department department = Department.values()[departmentChoice - 1];    // Retrieve selected department.
        System.out.println("Selected Department: " + department);             // Confirm selected department.
        
        
        System.out.println("--- Select Manager Type:");     // Enter to select manager type.
        for (ManagerType type : ManagerType.values()) { // Iterate through manager types.
            System.out.println((type.ordinal() + 1) + ". " + type.name().replace("_", " ") ); // Print each manager type with index.
        }
        int managerChoice = getValidChoice(ManagerType.values().length);   // Get valid manager type choice.
        ManagerType managerType = ManagerType.values()[managerChoice - 1]; // Retrieve selected manager type.
        System.out.println("Selected Manager Type: " + managerType);       // Confirm selected manager type.
        
        Employee employee = new Employee(name, employeeType, department, managerType, false);   // Create new employee with selected attributes.
        employees.add(employee);                // Add employee to employees list.
        newlyAddedEmployees.add(employee);      // Add employee to newly added employees list.
        System.out.println("*** " + name + " has been added successfully! ***");        // Confirm successful addition.
        System.out.println("\nAll newly added employees:");     // Print all newly added employees.
        for (Employee e : newlyAddedEmployees) {    // Loop through all newly added employees.
            System.out.println(e);                  // Print each employee's details.
        }
    }
    
    // 5 random employees with unique names and print all employees.
    private static void randomEmployees() {
        if (allNames.isEmpty()) {   // If the list of names is empty.
            System.out.println("No names available to select random employees!");   // Print that it is empty.
            return; // Exit the function.
        }
        ArrayList<Employee> newEmployees = new ArrayList<>();   // List to store newly employees.
        HashSet<String> usedNames = new HashSet<>();            // Set to track used names and prevent duplicates.
        while (newEmployees.size() < 5) {   // Generate exactly 5 employees.
            String name = allNames.get(random.nextInt(allNames.size()));    // Select random name from allNames.
        if (usedNames.add(name)) {          // Add name to set, only proceed if name is unique.
            EmployeeType employeeType = EmployeeType.values()[random.nextInt(EmployeeType.values().length)];// Random manager type.
            Department department = Department.values()[random.nextInt(Department.values().length)];        // Random department
            ManagerType managerType = ManagerType.values()[random.nextInt(ManagerType.values().length)];    // Random employee type.
            
            boolean isFromFile = allNames.indexOf(name) < employees.size() && employees.get(allNames.indexOf(name)).isFromFile();   // Check if name is from file
            Employee employee = new Employee(name, employeeType, department, managerType, isFromFile);  // Create new employee.
            employees.add(employee);        // Add employee to employees list.
            newEmployees.add(employee);     // Add employee to newEmployees list.
            }
        }
        System.out.println("\n--- 5 employees randomly selected with a Coach Type and Team:");    // Print header for generated employees.
        for (Employee e : newEmployees) {   // Loop through newly generated employees.
            System.out.println(e);          // Print each employee's details.
        }
        
        System.out.println("\n--- All unsorted employees:");   // Print header for all employees.
        for (Employee e : employees) {  // Loop through all employees.
            System.out.println(e);      // Print each employee's details.
        }
    }
}

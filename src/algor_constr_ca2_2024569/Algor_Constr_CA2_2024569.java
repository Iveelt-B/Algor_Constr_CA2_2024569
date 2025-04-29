/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algor_constr_ca2_2024569;

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
        
    }
    
    // Show the menu.
    private static void showMenu() {
        System.out.println("--- Tech Company Management System ---");
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
                System.out.println("Exiting program...");
                System.exit(0); 
        }
    }
    
    // Sort the list and show the first 20 employees.
    private static void sortDisplayList() {
        if (employees.isEmpty()) {
            System.out.println("List is empty!\n");
            return;
        }
        SortingAlgorithm.insertonSort(employees);
        System.out.println("First 20 sorted people:\n");
        for (int e = 0; e < Math.min(20, employees.size()); e++) {
            System.out.println(employees.get(e));
        }
    }
    
    private static void searchEmployee() {
        
    }
    
    private static void addNewEmployee() {
        
    }
    
    private static void randomEmployees() {
        
    }
   
}

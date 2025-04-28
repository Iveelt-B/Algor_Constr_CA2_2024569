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
//            int choice = getValidChoice();
//            handleMenuChoice(choice);
        }
    }
    
    public static void loadFromFile() {
        String filename = "/Users/iveelteddie/NetBeansProjects/Algor_Constr_CA2_2024569/src/algor_constr_ca2_2024569/Applicants_Form.txt";
        
    }
    
    private static void showMenu() {
        System.out.println("\n---- Tech Company Management System ----");
        
    }
    
//    private static int getValidChoice() {
//        
//    }
    
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
    
    private static void sortDisplayList() {
        
    }
    
    private static void searchEmployee() {
        
    }
    
    private static void addNewEmployee() {
        
    }
    
    private static void randomEmployees() {
        
    }
   
}

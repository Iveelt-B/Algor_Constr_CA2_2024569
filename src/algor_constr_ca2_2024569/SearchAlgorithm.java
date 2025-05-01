/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algor_constr_ca2_2024569;

import java.util.ArrayList;     // Import ArrayList class.

/**
 *
 * @author iveelteddie
 */
public class SearchAlgorithm {
    // Performs Binary Search on an ArrayList to find a employee by name.
    public static Employee binarySearch(ArrayList<Employee> employees, String name) {
        MyArrayList<Employee> myList = new MyArrayList<>(employees);    // Create a MyArrayList object.
        return myList.binarySearchNonRecursive(name);                   // Call non-recursive Binary Search.
    }
    
    // Performs recursive Binary Search on an ArrayList to find a employee by name.
    public static Employee binarySearchRecursive(ArrayList<Employee> employees, String name) {
        MyArrayList<Employee> myList = new MyArrayList<>(employees);    // Create a MyArrayList object.
        return myList.binarySearchRecursive(name);                      // Call recursive Binary Search.
    }
}

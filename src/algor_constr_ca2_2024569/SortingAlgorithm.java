/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algor_constr_ca2_2024569;

import java.util.ArrayList;

/**
 *
 * @author iveelteddie
 */
public class SortingAlgorithm {
    // Initiates recursive Insertion Sort on the ArrayList of employees.
    public static void insertionSort(ArrayList<Employee> employees) {
        insertionSortRecursive(employees, employees.size());    // Call recursive helper with full list size.
    }
    
    // Recursively sorts the ArrayList using Insertion Sort.
    private static void insertionSortRecursive(ArrayList<Employee> employees, int e) {
        if (e <= 1) return;                         // list of size 1 or less is sorted.
        insertionSortRecursive(employees, e - 1);   // Recursively sort the first e-1 elements.
        Employee pos = employees.get(e - 1);        // Get the current element to insert.
        int n = e - 2;                              // Index of the last sorted element.
        while (n >= 0 && employees.get(n).getName().compareTo(pos.getName()) > 0) {     // Compare with previous elements.
            employees.set(n + 1, employees.get(n)); // Shift larger elements to the end.
            n--;                    // Move to the previous element.
        }
        employees.set(n + 1, pos);  // Place pos in its correct position.
    }
}

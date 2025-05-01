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
public class MyArrayList<ElemType extends Employee> extends ArrayList<ElemType> {
    // Constructor: Initializes the list with elements from the input ArrayList.
    public MyArrayList(ArrayList<ElemType> employees) {
        super(employees);   // Call the ArrayList constructor to copy elements.
    }
    
    // Non-recursive Binary Search: Iteratively searches for a employee by name.
    public ElemType binarySearchNonRecursive(String name) {
        int start = 0;  // Start boundary of the search.
        int end = this.size() - 1;  // End boundary of the search.
        while (start <= end) {      // Continue searching while boundaries are valid.
            int middle = start + (end - start) / 2;    // Calculate the middle index.
            int comparison = this.get(middle).getName().compareTo(name);    // Compare names.
            if (comparison == 0) {       // If the name matches.
                return this.get(middle); // Return the matching employee.
            } else if (comparison < 0) { // If the name is greater.
                start = middle + 1;      // Move to the end half.
            } else {                     // If the name is smaller.
                end = middle - 1;        // Move to the start half.
            }
        } return null;    // Return null if the employee is not found.
    }
    
    // Recursive Binary Search: Recursively searches for a employee by name.
    public ElemType binarySearchRecursive(String name) {
        int start = 0;             // Start boundary of the search.
        int end = this.size() - 1; // End boundary of the search.
        if (start > end) {         // If the search range is empty.
            return null;           // Return null if the employee is not found.
        }
        int middle = start + (end - start) / 2;                      // Calculate the middle index.
        int comparison = this.get(middle).getName().compareTo(name); // Compare names.
        if (comparison == 0) {          // If the name matches.
            return this.get(middle);    // Return the matching employee.
        } else if (comparison < 0) {    // If the name is greater.
            MyArrayList<ElemType> rightHalf = new MyArrayList<>(new ArrayList<>(this.subList(middle + 1, end + 1))); // Create a sublist for the end half.
            return rightHalf.binarySearchRecursive(name);   // Recursively search the end half.
        } else {    // If the name is smaller.
            MyArrayList<ElemType> leftHalf = new MyArrayList<>(new ArrayList<>(this.subList(start, middle)));   // Create a sublist for the start half.
            return leftHalf.binarySearchRecursive(name);    // Recursively search the start half.
        }
    }
}


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
    
    public static void insertionSort(ArrayList<Employee> employees) {
        int e = employees.size();
        for (int i = 1; i < e; i++) {
            Employee pos = employees.get(i);
            int n = i - 1;
            
            while (n >= 0 && employees.get(n).getName().compareTo(pos.getName()) > 0) {
                employees.set(n + 1, employees.get(n));
                n--;
            }
            employees.set(n + 1, pos);
        }
    }
}

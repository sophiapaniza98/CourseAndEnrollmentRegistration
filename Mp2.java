/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mp2;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Mp2 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            HashSet<String> courseCodes = new HashSet<>();
            HashSet<String> enrollmentPairs = new HashSet<>();
            HashMap<Integer, String> students = new HashMap<>();
            
            int choice;
            
            do {
                System.out.println("\n1 Add student");
                System.out.println("2 Add course");
                System.out.println("3 Enroll");
                System.out.println("4 List student courses");
                System.out.println("5 List courses");
                System.out.println("0 Exit");
                System.out.print("Enter choice: ");
                
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();
                        
                        if (students.containsKey(id)) {
                            System.out.println("Student already exists");
                        } else {
                            students.put(id, name);
                            System.out.println("Student added");
                        }
                        break;
                        
                    case 2:
                        System.out.print("Enter course code: ");
                        String course = sc.next();
                        
                        if (courseCodes.add(course)) {
                            System.out.println("Course added");
                        } else {
                            System.out.println("Duplicate rejected");
                        }
                        break;
                        
                    case 3:
                        System.out.print("Enter student ID: ");
                        int studentId = sc.nextInt();
                        
                        if (!students.containsKey(studentId)) {
                            System.out.println("Student not found");
                            break;
                        }
                        
                        System.out.print("Enter course code: ");
                        String enrollCourse = sc.next();
                        
                        if (!courseCodes.contains(enrollCourse)) {
                            System.out.println("Course not found");
                            break;
                        }
                        
                        String pair = studentId + ":" + enrollCourse;
                        
                        if (enrollmentPairs.add(pair)) {
                            System.out.println("Enrollment added");
                        } else {
                            System.out.println("Duplicate enrollment rejected");
                        }
                        break;
                        
                    case 4:
                        System.out.print("Enter student ID: ");
                        int searchId = sc.nextInt();
                        
                        if (!students.containsKey(searchId)) {
                            System.out.println("Student not found");
                        } else {
                            System.out.println("Courses:");
                            
                            boolean found = false;
                            
                            for (String enrollment : enrollmentPairs) {
                                String[] parts = enrollment.split(":");
                                
                                if (Integer.parseInt(parts[0]) == searchId) {
                                    System.out.println(parts[1]);
                                    found = true;
                                }
                            }
                            
                            if (!found) {
                                System.out.println("No enrolled courses");
                            }
                        }
                        break;
                        
                    case 5:
                        if (courseCodes.isEmpty()) {
                            System.out.println("No courses available");
                        } else {
                            for (String c : courseCodes) {
                                System.out.println(c);
                            }
                        }
                        break;
                        
                    case 0:
                        System.out.println("Program terminated");
                        break;
                        
                    default:
                        System.out.println("Invalid choice");
                }
                
            } while (choice != 0);
        }
    }
}
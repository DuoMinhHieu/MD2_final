package view;

import inPut.Input;
import controller.StudentController;
import controller.StudentManagement;
import IOFile.ReadWriteFile;
import IOFile.ReadWriteFile1;

import java.util.Scanner;

public class Menu {
    public static void sortStudent() {
        Scanner scanner = new Scanner(System.in);
           int choice;
           do {
               System.out.println("-----Danh sach sap xep-----");
               System.out.println("1. Tang dan");
               System.out.println("2. Giam dan");
               System.out.println("0. thoat ");
               choice = scanner.nextInt();
               scanner.nextLine();
               switch (choice) {
                   case 1:
                       StudentManagement.sortAvgScoreAscending();
                       break;
                   case 2:
                       StudentManagement.sortAvgScoreDescending();
                       break;
                   case 0:
                       System.out.println("Thoat");
                       break;
                   default:
                       System.out.println("Xay ra loi!");
                       break;
               }
           }
           while (choice != 0);
    }
}


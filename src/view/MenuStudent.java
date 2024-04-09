package view;

import controller.StudentManagement;
import java.util.Scanner;

public class MenuStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---CHUONG trinh quan ly sinh vien---");
            System.out.println("Chon chuc nang theo so de tiep tuc");
            System.out.println("1. Xem danh sach sinh vien");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Sap xep");
            System.out.println("6. Doc tu file ");
            System.out.println("7. Ghi vao file");
            System.out.println("0. Thoat ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    StudentManagement.showStudentList();
                    break;
                case 2:
                    StudentManagement.addNewStudent(scanner);
                    break;
                case 3:
                    System.out.println("Nhap ID");
                    int idUpdate = scanner.nextInt();
                    StudentManagement.updateStudent(idUpdate,scanner);
                    break;
                case 4:
                    System.out.println("Nhap ID");
                    int idRemove = scanner.nextInt();
                    StudentManagement.removeStudent(idRemove);
                    break;
                case 5:
                    Menu.sortStudent();
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Vui long thu lai!");
                    break;
            }
        } while (choice != 0);
    }
}
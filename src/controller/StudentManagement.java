
package controller;
import IOFile.ReadWriteFile1;
import controller.StudentProduct;
import IOFile.ReadWriteFile;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static ReadWriteFile readWriteFileStudent = new ReadWriteFile1();

    public void writeFile(List<StudentProduct> studentList) {

    }
    private static List<StudentProduct> studentsList = readWriteFileStudent.readFile();
    public static void showStudentList() {
        if (studentsList.isEmpty()) {
            System.out.println("Khong tim thay sinh vien!");
        }
        for (StudentProduct student : studentsList) {
            System.out.println(student);
        }
    }

    public static void addNewStudent(Scanner scanner) {
        int id;
        boolean idExists;
        do{
            System.out.println("Nhap ma sinh vien: ");
            id = scanner.nextInt();
            idExists = false;
            for(StudentProduct student: studentsList){
                if(student.getId() == id){
                    System.err.println("Ma sinh vien khong ton tai, vui long thu lai!");
                    idExists = true;
                    break;
                }
            }
        }while (idExists);
        System.out.println("Nhap ten sinh vien ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nhap tuoi ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Chon gioi tinh ");
        System.out.println("1. Nam \n2. Nu");
        int choice = scanner.nextInt();
        String gender = null;
        switch (choice){
            case 1:
                gender = "Nam";
                break;
            case 2:
                gender = "Nu";
                break;
            default:
                System.out.println("Lua chon khong hop le");
        }
        System.out.println("Nhap dia chi: ");
        String address = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nhap diem trung binh");
        double avgScore = scanner.nextDouble();
        StudentProduct student = new StudentProduct(id,name,age,gender,address,avgScore);
        studentsList.add(student);
        readWriteFileStudent.writeFile(studentsList);
    }
    public static void findStudent(int id) {
        for (StudentProduct student : studentsList) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }
    public static void removeStudent(int id) {
        StudentProduct removeStudents = null;
        for (StudentProduct student : studentsList) {
            if (student.getId() == id) {
                removeStudents = student;
                break;
            }
        }
        if (removeStudents != null) {
            studentsList.remove(removeStudents);
            readWriteFileStudent.writeFile(studentsList);
        } else {
            System.out.println("Khong tim thay sinh vien!");
        }
    }
    public static void updateStudent(int id, Scanner scanner) {
        boolean found = false;
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId() == id) {
                found = true;
                System.out.println("Nhap ma sinh vien moi:" + id);
                scanner.nextLine();
                System.out.println("Nhap ten: ");
                String name = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Nhap tuoi: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Chon gioi tinh: ");
                System.out.println("1. Nam \n2. Nu");
                int choice = scanner.nextInt();
                String gender = null;
                switch (choice){
                    case 1:
                        gender = "Nam";
                        break;
                    case 2:
                        gender = "Nu";
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                }
                System.out.println("Nhap dia chi: ");
                String address = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Nhap diem trung binh");
                double avgScore = scanner.nextDouble();
                studentsList.get(i).setName(name);
                studentsList.get(i).setAge(age);
                studentsList.get(i).setAddress(address);
                studentsList.get(i).setGender(gender);
                studentsList.get(i).setAvgScore(avgScore);
                readWriteFileStudent.writeFile(studentsList);
                System.out.println("Hoan thanh cap nhat!");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien!");
        }
    }
    public static void sortAvgScoreAscending() {
        studentsList.sort(Comparator.comparingDouble(StudentProduct::getAvgScore));
        showStudentList();
    }
    public static void sortAvgScoreDescending() {
        studentsList.sort(Comparator.comparingDouble(StudentProduct::getAvgScore).reversed());
        showStudentList();
    }
}

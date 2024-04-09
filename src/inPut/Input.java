package inPut;

import java.util.Scanner;

public class Input {
    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter number");
            }
        }
    }
    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}

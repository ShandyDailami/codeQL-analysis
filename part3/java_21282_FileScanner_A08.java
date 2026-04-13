import java.io.File;
import java.util.Scanner;

public class java_21282_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file you want to search:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            System.out.println("The file exists.");
        } else {
            System.out.println("The file does not exist.");
        }

        scanner.close();
    }
}
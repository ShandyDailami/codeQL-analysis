import java.io.File;
import java.util.Scanner;

public class java_08854_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                    // Add security-sensitive operations here
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    // Add security-sensitive operations here
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}
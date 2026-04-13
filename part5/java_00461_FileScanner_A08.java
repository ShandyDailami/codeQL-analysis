import java.io.File;
import java.util.Scanner;

public class java_00461_FileScanner_A08 {
    public static void main(String[] args) {
        // create a new file scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}
import java.io.File;
import java.util.Scanner;

public class java_35459_FileScanner_A08 {
    public static void main(String[] args) {
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
            } else {
                System.out.println("No files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }
}
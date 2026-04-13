import java.io.File;
import java.util.Scanner;

public class java_06521_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getName());
                        }
                    }
                } else {
                    System.out.println("No files in the directory!");
                }
            } else {
                System.out.println("It's not a directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }
}
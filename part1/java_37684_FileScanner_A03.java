import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_37684_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                        System.out.println("File Path: " + file.getPath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory Name: " + file.getName());
                        System.out.println("Directory Path: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }
}
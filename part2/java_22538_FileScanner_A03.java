import java.io.File;
import java.util.Scanner;

public class java_22538_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File Name: " + file.getName());
                    System.out.println("File Path: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        scanner.close();
    }
}
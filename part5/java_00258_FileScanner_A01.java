import java.io.File;
import java.util.Scanner;

public class java_00258_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(directoryPath);

        // Get the list of all files in the directory and its subdirectories
        File[] files = fileScanner.getFiles();

        if (files.length == 0) {
            System.out.println("No files found in the directory or its subdirectories.");
        } else {
            System.out.println("Files in the directory and its subdirectories:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}
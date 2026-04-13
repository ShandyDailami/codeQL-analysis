import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29454_FileScanner_A03 {

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
                        System.out.println("File: " + file.getPath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No files or directories found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }
}
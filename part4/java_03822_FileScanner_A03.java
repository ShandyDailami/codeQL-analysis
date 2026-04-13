import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03822_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] allFiles = directory.listFiles();

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the specified directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        input.close();
    }
}
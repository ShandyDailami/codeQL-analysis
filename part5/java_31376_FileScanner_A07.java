import java.io.File;
import java.util.Scanner;

public class java_31376_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in " + directoryPath);

            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsolutePath());

                        // Security-sensitive operation: Check if the file is empty
                        if (file.length() == 0) {
                            System.out.println("AuthFailure: File " + file.getName() + " is empty.");
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());

                        // Security-sensitive operation: Check if the directory is empty
                        File[] filesInDirectory = file.listFiles();
                        if (filesInDirectory != null) {
                            for (File f : filesInDirectory) {
                                if (f.isFile()) {
                                    System.out.println("File inside directory: " + f.getAbsolutePath());

                                    // Security-sensitive operation: Check if the file inside the directory is empty
                                    if (f.length() == 0) {
                                        System.out.println("AuthFailure: File " + f.getName() + " inside directory is empty.");
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("No files found in " + directoryPath);
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }
    }
}
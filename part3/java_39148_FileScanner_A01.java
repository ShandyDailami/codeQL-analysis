import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_39148_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                    }
                });
            } else {
                System.out.println("No files or directories found in the specified directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}
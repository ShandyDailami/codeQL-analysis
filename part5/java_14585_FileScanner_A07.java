import java.io.File;
import java.util.Scanner;

public class java_14585_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            // File is a text file
                            System.out.println("File: " + file.getName());
                        } else if (file.isDirectory()) {
                            // Directory
                            System.out.println("Directory: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Given path is not a directory");
            }
        } else {
            System.out.println("Directory not found");
        }
    }
}
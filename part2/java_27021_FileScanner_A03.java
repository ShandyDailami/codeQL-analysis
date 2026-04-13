import java.io.File;
import java.util.Scanner;

public class java_27021_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    System.out.println("File Name: " + fileName);

                    // Check if file name contains special characters
                    if (fileName.matches(".*\\p{Punct}.*")) {
                        System.out.println("File name contains a special character!");
                    }

                    // Check if file name ends with a period
                    if (fileName.matches(".*\\.+")) {
                        System.out.println("File name ends with a period!");
                    }

                    // Check if file name starts with a digit
                    if (fileName.matches(".*\\d.*")) {
                        System.out.println("File name starts with a digit!");
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory!");
        }

        scanner.close();
    }
}
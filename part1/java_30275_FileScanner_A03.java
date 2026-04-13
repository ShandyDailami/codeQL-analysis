import java.io.File;
import java.util.Scanner;

public class java_30275_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        System.out.println("File: " + fileName);

                        // Security sensitive operation: Check if the file name contains a certain string
                        if (fileName.contains("injection")) {
                            System.out.println("Injection detected in the file name!");
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_07997_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        try {
                            if (file.canRead()) {
                                System.out.println("File: " + file.getName());
                            } else {
                                System.out.println("File: " + file.getName() + " is read-protected");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                });
            } else {
                System.out.println("No files in the directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}
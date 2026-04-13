import java.io.File;
import java.util.Scanner;

public class java_13244_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".txt")) {
                        printAuthFailureInfo(file);
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void printAuthFailureInfo(File file) {
        // This function will be used to print the authentication failure info.
        // For simplicity, it just prints the file name.
        System.out.println("Authentication failure detected in: " + file.getPath());
    }
}
import java.io.File;
import java.util.Scanner;

public class java_11597_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        AuthFailureChecker checker = new AuthFailureChecker(file);
                        if (checker.isAuthFailure()) {
                            System.out.println("AuthFailure detected in file: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }

        scanner.close();
    }
}
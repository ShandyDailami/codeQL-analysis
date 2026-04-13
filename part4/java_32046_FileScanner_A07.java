import java.io.File;
import java.util.Scanner;

public class java_32046_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] authFailureFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (authFailureFiles != null) {
                for (File authFailureFile : authFailureFiles) {
                    try (Scanner fileScanner = new Scanner(authFailureFile)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println("AuthFailure: " + line);
                       
                            // Here's a line for a security-sensitive operation related to AuthFailure
                            // For example, check if a line contains a known attack pattern
                            if (line.contains("attack")) {
                                System.out.println("Detected attack pattern in auth failure file. Proceeding with caution.");
                            }
                        }
                    }
                }
            } else {
                System.out.println("No .txt files in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}
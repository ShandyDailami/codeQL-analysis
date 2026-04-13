import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_38782_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            try {
                                Scanner fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    // Perform security-sensitive operations related to A07_AuthFailure here
                                    // e.g., checking for username and password in a text file
                                }
                                fileScanner.close();
                            } catch (FileNotFoundException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}
import java.io.File;
import java.util.Scanner;

public class java_15647_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.next();
        File file = new File(dirPath);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    try {
                        // Simulating security-sensitive operation related to AuthFailure
                        // Here, read the file content and compare it with a predefined value
                        Scanner fileScanner = new Scanner(f);
                        String fileContent = fileScanner.nextLine();
                        String predefinedValue = "A07_AuthFailure";
                        if (fileContent.equals(predefinedValue)) {
                            System.out.println("AuthFailure detected in file: " + f.getName());
                        }
                    } catch (Exception e) {
                        System.out.println("Error occurred while processing file: " + f.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }
}
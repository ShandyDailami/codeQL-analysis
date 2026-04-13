import java.io.File;
import java.util.Scanner;

public class java_25869_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".txt")) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                       
                            // Check for known vulnerabilities
                            if (line.contains("password")) {
                                System.out.println("Access Denied: Potential security vulnerability in file " + file.getName());
                            }
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file " + file.getName());
                    }
                }
            }
        }
    }
}
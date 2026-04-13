import java.io.File;
import java.util.Scanner;

public class java_17672_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Could not list files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println("Processing file: " + file.getName());

                // Add your security-sensitive operations here. For example, this code
                // reads the file content and potentially prints it to the console:
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                   
                        // Add your security-sensitive operations here. For example, this code
                        // verifies if the line contains any potential injection vulnerabilities.
                        // In real application, you should use a proper library for security operations.
                        if (line.contains("<script>")) {
                            System.out.println("Suspicious line detected in file: " + file.getName());
                        }
                    }
                    fileScanner.close();
                } catch (Exception e) {
                    System.out.println("Error processing file: " + file.getName());
                }
            }
        }
    }
}
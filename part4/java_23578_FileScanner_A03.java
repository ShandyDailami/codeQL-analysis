import java.io.File;
import java.util.Scanner;

public class java_23578_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".java")) {
                            try {
                                // Read file content
                                Scanner fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    // Check for injection vulnerability
                                    if (line.contains("inject")) {
                                        System.out.println("Suspicious line found: " + line);
                                    }
                                }
                                fileScanner.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}
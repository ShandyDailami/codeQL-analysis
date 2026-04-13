import java.io.File;
import java.util.Scanner;

public class java_08225_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the directory:");
            String dir = scanner.nextLine();

            File startDir = new File(dir);

            File[] listOfFiles = startDir.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        // File found, check if it's a .java file
                        if (file.getName().endsWith(".java")) {
                            // If so, check if it's a suspicious or security-sensitive operation
                            suspiciousOperation(file);
                        }
                    } else if (file.isDirectory()) {
                        // Recursively check inside the directory
                        findSuspiciousFiles(file);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void suspiciousOperation(File file) {
        // TODO: Implement your suspicious operation here
        // This is just a placeholder, replace it with your actual suspicious operation
        System.out.println("Suspicious operation found in: " + file.getPath());
    }

    private static void findSuspiciousFiles(File dir) {
        // Recursively check inside the directory
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // File found, check if it's a .java file
                    if (file.getName().endsWith(".java")) {
                        // If so, check if it's a suspicious or security-sensitive operation
                        suspiciousOperation(file);
                    }
                } else if (file.isDirectory()) {
                    // Recursively check inside the directory
                    findSuspiciousFiles(file);
                }
            }
        }
    }
}
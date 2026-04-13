import java.io.File;
import java.util.Scanner;

public class java_33021_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && isSecuritySensitiveOperation(file)) {
                    System.out.println("Security-Sensitive Operation detected in file: " + file.getPath());
                }
           
                if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }

    private static boolean isSecuritySensitiveOperation(File file) {
        // Implement security-sensitive operations related to A03_Injection
        // For simplicity, this method just checks if the file is a .txt file
        return file.getName().endsWith(".txt");
    }

    private static void listFiles(File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && isSecuritySensitiveOperation(file)) {
                    System.out.println("Security-Sensitive Operation detected in file: " + file.getPath());
                }

                if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }
}
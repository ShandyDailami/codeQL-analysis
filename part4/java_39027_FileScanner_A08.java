import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class java_39027_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            fileScan(directory);
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }

    public static void fileScan(File directory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // Check if the file is a security-sensitive operation.
                    if (isSecuritySensitiveOperation(file)) {
                        System.out.println("Security-sensitive operation found in: " + file.getPath());
                    }
                } else if (file.isDirectory()) {
                    fileScan(file);
                }
            }
        }
    }

    private static boolean isSecuritySensitiveOperation(File file) {
        // Implement the logic to check if the file is a security-sensitive operation.
        // Here, we're simply checking if the file name ends with "_sensitive".
        return file.getName().endsWith("_sensitive");
    }
}
import java.io.File;
import java.util.Scanner;

public class java_04487_FileScanner_A08 {
    public static void main(String[] args) {
        // Use the Scanner to get user input for directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        // Use FileScanner to scan files in the directory
        FileScanner fileScanner = new FileScanner(directory);

        // Use a file filter to only scan directories
        fileScanner.filter(File::isDirectory);

        // Use a file visitor to visit each file
        fileScanner.visit(file -> {
            // Check if the file is not executable
            if (!file.canExecute()) {
                System.out.println("File " + file.getPath() + " is not executable.");
            }

            // Check if the file has a security owner
            SecurityOwnerChecker ownerChecker = new SecurityOwnerChecker(file);
            if (ownerChecker.hasSecurityOwner()) {
                System.out.println("File " + file.getPath() + " has a security owner.");
            }

            // Check if the file has integrity failures
            FileIntegrityChecker integrityChecker = new FileIntegrityChecker(file);
            if (integrityChecker.hasIntegrityFailure()) {
                System.out.println("File " + file.getPath() + " has integrity failures.");
            }
        });

        scanner.close();
    }
}
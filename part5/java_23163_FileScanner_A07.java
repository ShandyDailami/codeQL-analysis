import java.io.File;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class java_23163_FileScanner_A07 {
    private static final String AUTH_FAILURE_DIRECTORY = "/path/to/auth/failure/directories";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] authFailureFiles = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

            if (authFailureFiles == null) {
                System.out.println("No files found in the directory.");
                return;
            }

            for (File file : authFailureFiles) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // Add your security-sensitive operation related to A07_AuthFailure here.
                    }
                    fileScanner.close();
                } catch (InvalidParameterException e) {
                    System.out.println("Invalid parameter provided. Skipping file: " + file.getName());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
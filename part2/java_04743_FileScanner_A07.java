import java.io.File;
import java.util.Scanner;

public class java_04743_FileScanner_A07 {
    private static final String AUTH_FAILURE_PATTERN = "%s%n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] authFailureFiles = directory.listFiles((dir, name) -> name.matches(".*AuthFailure.*"));

        if (authFailureFiles == null) {
            System.out.println("No AuthFailure files found in the directory.");
            return;
        }

        for (File authFailureFile : authFailureFiles) {
            try (Scanner fileScanner = new Scanner(authFailureFile)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.matches(".*AuthFailure.*")) {
                        System.out.println(String.format(AUTH_FAILURE_PATTERN, authFailureFile.getAbsolutePath()));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error processing file: " + authFailureFile.getAbsolutePath());
            }
        }

        scanner.close();
    }
}
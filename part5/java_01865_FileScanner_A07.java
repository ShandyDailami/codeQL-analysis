import java.io.File;
import java.util.Scanner;

public class java_01865_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] authFailuresFiles = directory.listFiles((dir, name) -> name.endsWith(".authFailure"));

            if (authFailuresFiles != null) {
                for (File file : authFailuresFiles) {
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println("Line from authFailure file: " + line);

                            // Implement your security-sensitive operations here.
                            // For example, verify the format of the line,
                            // check for suspicious activity, or perform other security-related operations.

                            // TODO: Remove the comment below after implementing the security-sensitive operations.
                            // System.out.println("Security-sensitive operation is performed on line: " + line);
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error occurred while processing file: " + file.getName());
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No authFailure files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}
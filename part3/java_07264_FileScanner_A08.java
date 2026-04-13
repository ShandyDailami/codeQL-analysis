import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_07264_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] logFiles = directory.listFiles((dir, name) -> name.endsWith(".log"));

            if (logFiles != null) {
                Arrays.stream(logFiles)
                      .filter(file -> checkFileIntegrity(file))
                      .forEach(file -> System.out.println("Integrity failure detected in file: " + file.getName()));
            } else {
                System.out.println("No log files found in directory.");
            }
        } else {
            System.out.println("Given directory does not exist or it is not a directory.");
        }

        scanner.close();
    }

    private static boolean checkFileIntegrity(File file) {
        // Implementation of the security-sensitive operation to check file integrity
        // This is a placeholder implementation, replace it with actual implementation
        return true;
    }
}
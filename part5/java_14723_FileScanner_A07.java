import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14723_FileScanner_A07 {
    private static final String AUTH_FAILURE_MESSAGE = "Authentication failure, cannot proceed.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && hasCorrectPermissions(file)) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println(AUTH_FAILURE_MESSAGE);
                        }
                    }
                }
            } else {
                System.out.println(AUTH_FAILURE_MESSAGE);
            }
        } else {
            System.out.println(AUTH_FAILURE_MESSAGE);
        }

        scanner.close();
    }

    private static boolean hasCorrectPermissions(File file) {
        // Assume we're using a Unix-based system where the file owner can read the file.
        // You would need to implement additional security checks based on your specific use case.
        return file.canRead();
    }
}
import java.io.File;
import java.util.Scanner;

public class java_34583_FileScanner_A01 {
    private static final String PATTERN = "target"; // Replace with your pattern

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        File[] targetFiles = directory.listFiles((dir, name) -> name.endsWith(PATTERN));

        if (targetFiles != null) {
            for (File targetFile : targetFiles) {
                System.out.println("Reading file: " + targetFile.getAbsolutePath());
                // Read the file here and handle the file.
                // This is a placeholder for a real implementation.
            }
        } else {
            System.out.println("No target files found in the directory.");
        }
    }
}
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_26227_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in the directory!");
            return;
        }

        System.out.println("Searching for sensitive files in the directory: " + directoryPath);

        // Filter out files that contain "A07_AuthFailure"
        Arrays.stream(files).filter(file -> file.getName().contains("A07_AuthFailure")).forEach(file -> {
            System.out.println("Found sensitive file: " + file.getPath());

            // Security-sensitive operation: Printing file content
            try {
                Scanner fileScanner = new Scanner(file.toPath());
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("Error reading file: " + file.getPath());
            }
        });
    }
}
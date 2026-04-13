import java.io.File;
import java.util.Scanner;

public class java_35001_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the file name to search:");
            String fileName = scanner.nextLine();

            File directory = new File(directoryPath);

            File[] matchingFiles = directory.listFiles((dir, name) -> name.equals(fileName));

            if (matchingFiles == null || matchingFiles.length == 0) {
                System.out.println("No files found with the name " + fileName);
            } else {
                System.out.println("Found the following file(s):");
                for (File file : matchingFiles) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
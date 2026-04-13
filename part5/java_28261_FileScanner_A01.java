import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28261_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory"; // replace with your directory path
        String extension = "extension_to_filter"; // replace with your extension

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a name to search for:");
            String searchName = scanner.nextLine();

            File directory = new File(directoryPath);
            File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (matchingFiles != null) {
                for (File file : matchingFiles) {
                    if (file.getName().contains(searchName)) {
                        System.out.println("Found file: " + file.getPath());
                    }
                }
            } else {
                System.out.println("Error listing files in directory.");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error finding file: " + e.getMessage());
        }
    }
}
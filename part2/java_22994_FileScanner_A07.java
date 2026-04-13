import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22994_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory"; // replace with your directory path
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String filePath = directoryPath + "/" + scanner.nextLine();
                try (Scanner fileScanner = new Scanner(new File(filePath))) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // Perform security-sensitive operations related to A07_AuthFailure here.
                        // This is a placeholder, you should replace it with your own operations.
                        // For example, checking for a particular string in a file.

                        if (line.contains("auth failure")) {
                            System.out.println("Auth failure detected in file: " + filePath);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found");
        }
    }
}
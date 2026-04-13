import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class java_30518_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "/path/to/directory"; // Replace with the directory you want to scan

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to search:");
        String fileName = scanner.nextLine();

        File directory = new File(DIRECTORY_PATH);

        try (Scanner fileScanner = new Scanner(directory)) {
            while (fileScanner.hasNext()) {
                String filePath = fileScanner.nextLine();

                if (filePath.endsWith(fileName)) {
                    File file = new File(filePath);

                    if (file.canRead()) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Unable to read file: " + file.getAbsolutePath());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}
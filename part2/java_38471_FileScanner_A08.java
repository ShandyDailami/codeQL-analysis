import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38471_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the name of the file you want to read:");
            String fileName = scanner.nextLine();

            File file = new File(directory, fileName);

            if (!file.exists() || file.isDirectory()) {
                System.out.println("Invalid file");
                return;
            }

            if (file.canRead()) {
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Line: " + line);
                   
                        // add security-sensitive operations here
                    }
                }
            } else {
                System.out.println("File is not readable");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
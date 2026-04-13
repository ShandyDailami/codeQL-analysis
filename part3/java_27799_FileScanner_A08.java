import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27799_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Provide your directory path here
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String filePath = directoryPath + "/" + scanner.nextLine();
                readFile(new File(filePath));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + directoryPath);
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, you can add code to read and manipulate the file content
                // For example, you can print the content to the console
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        }
    }
}
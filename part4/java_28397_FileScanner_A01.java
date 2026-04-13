import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28397_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = "txt"; // replace with your file extension

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter file name:");
            String fileName = scanner.nextLine();

            File directory = new File(directoryPath);
            File file = new File(directory, fileName + "." + fileExtension);

            if (file.exists()) {
                System.out.println("File found: " + file.getAbsolutePath());
                printContent(file);
            } else {
                System.out.println("File not found: " + file.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void printContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_01295_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        System.out.println("Enter the file name or extension:");
        String fileName = scanner.nextLine();
        File file = new File(directory, fileName);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        System.out.println("Reading the file content...");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
import java.io.File;
import java.util.Scanner;

public class java_08274_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("File found, scanning...");
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // Here, we're just printing the line to the console
                        System.out.println("Line: " + line);
                    }
                } catch (Exception e) {
                    System.out.println("Error occurred while scanning file: " + e.getMessage());
                }
            } else {
                System.out.println("Provided path is not a file, not scanning.");
            }
        } else {
            System.out.println("File not found at the provided path: " + filePath);
        }
    }
}
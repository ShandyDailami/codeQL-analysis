import java.io.File;
import java.util.Scanner;

public class java_17725_FileScanner_A03 {

    public static void main(String[] args) {
        // Create a File object for the file to be scanned
        File file = new File("input.txt");

        // Use a Scanner to read the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Check if the line contains the string "A03_Injection"
                if (line.contains("A03_Injection")) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
import java.io.File;
import java.util.Scanner;

public class java_04511_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new File object
        File file = new File("input.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Create a new Scanner object
        Scanner scanner = new Scanner(file);

        // Use a while loop to read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close the scanner
        scanner.close();
    }
}
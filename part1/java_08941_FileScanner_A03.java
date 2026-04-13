import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08941_FileScanner_A03 {
    public static void main(String[] args) {
        // Step 1: Create a file scanner
        Scanner scanner = new Scanner(System.in);

        // Step 2: Prompt the user for a directory path
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Step 3: Create a file scanner for the directory path
        try (Scanner dirScanner = new Scanner(new File(dirPath))) {
            // Step 4: Use a while loop to read and print all the lines in the directory
            while (dirScanner.hasNextLine()) {
                String line = dirScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // Step 5: Handle the file not found exception
            System.out.println("File not found: " + e.getMessage());
        } finally {
            // Step 6: Close the scanner
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
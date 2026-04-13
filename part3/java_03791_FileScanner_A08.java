import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03791_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for file path
        System.out.println("Please enter the file path:");
        String filePath = scanner.nextLine();

        // Create FileScanner object
        File file = new File(filePath);

        // Verify if file exists
        if (!file.exists()) {
            System.out.println("The file does not exist!");
            return;
        }

        // Use FileScanner to read file content
        Scanner fileScanner = new Scanner(file);

        // Prompt user for line number to check integrity
        System.out.println("Please enter the line number to check integrity:");
        int lineNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        int count = 0;
        while (fileScanner.hasNextLine()) {
            count++;
            if (count == lineNumber) {
                System.out.println("Integrity failure detected in line " + count + "!");
                break;
            }
            fileScanner.nextLine();
        }

        // Close scanner
        fileScanner.close();
    }
}
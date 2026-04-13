import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01016_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        // Create the file path
        File file = new File(directoryPath + "/" + fileName);

        try {
            // Try to open the file
            Scanner fileScanner = new Scanner(file);

            // Read the file line by line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
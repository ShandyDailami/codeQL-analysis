import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28762_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        File file = new File(fileName);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Check if the file is readable
        if (!file.canRead()) {
            System.out.println("File is not readable!");
            return;
        }

        // Create a scanner for the file
        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("Enter the line to stop reading:");
            String stopLine = scanner.nextLine();

            // Read the file line by line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);

                // Stop reading when the stop line is found
                if (line.equals(stopLine)) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
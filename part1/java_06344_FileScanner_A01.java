import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_06344_FileScanner_A01 {

    public static void main(String[] args) {
        // Read the file name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Create a new File object for the file
        File file = new File(fileName);

        try {
            // Create a new Scanner for the file
            Scanner fileScanner = new Scanner(file);

            // Read and print the contents of the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // Close the Scanner
            fileScanner.close();

        } catch (FileNotFoundException e) {
            // Handle the exception
            System.out.println("File not found!");
        }
    }
}
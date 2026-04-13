import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31513_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a file scanner to find all files in the current directory
        FileScanner fileScanner = new FileScanner(new File("."), ".txt");

        // Use a scanner to read the file names
        Scanner scanner = new Scanner(fileScanner);

        // Use a loop to read the file names
        while (scanner.hasNextLine()) {
            String fileName = scanner.nextLine();
            System.out.println("File name: " + fileName);
        }

        // Close the scanner
        scanner.close();
    }

}
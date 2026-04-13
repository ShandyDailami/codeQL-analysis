import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29904_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Get a file from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Create a FileScanner
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        if (file.isDirectory()) {
            System.out.println("Given path is a directory, please enter a file path!");
            return;
        }

        // Create a FileScanner using FileScanner class
        FileScanner fileScanner = new FileScanner(file);

        // Print all lines in the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        fileScanner.close();
    }
}
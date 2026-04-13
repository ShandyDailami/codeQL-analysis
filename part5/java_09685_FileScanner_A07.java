import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09685_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the current directory
        File dir = new File(".");

        // Get a list of all files in the current directory
        File[] files = dir.listFiles();

        // Scan each file in the directory for "A07_AuthFailure.txt"
        for (File file : files) {
            if (file.getName().equals("A07_AuthFailure.txt")) {
                try {
                    // Try to open the file
                    Scanner scanner = new Scanner(file);

                    // If the file exists, print its contents
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }

                    // Close the scanner
                    scanner.close();
                } catch (FileNotFoundException e) {
                    // If the file does not exist, print an error message
                    System.out.println("Error: The file " + file.getName() + " was not found!");
                }
            }
        }
    }
}
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_05781_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner object for the directory where the files to be scanned are located.
        FileScanner scanner = new FileScanner(".");

        // Use a try-with-resources statement to automatically close the scanner when done.
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the name of a file to open:");
            String fileName = input.next();

            // Attempt to open the specified file.
            File file = new File(fileName);
            if (file.exists()) {
                // Scan the file to see if it can be opened.
                try (Scanner fileScanner = new Scanner(file)) {
                    // If it can, print out the contents of the file.
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                }
            } else {
                System.out.println("File does not exist.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
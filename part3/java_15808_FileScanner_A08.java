import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15808_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner object.
            FileScanner scanner = new FileScanner();

            // Request a file path from the user.
            System.out.print("Please enter the path of the file: ");
            Scanner input = new Scanner(System.in);
            String filePath = input.nextLine();

            // Create a File object from the user's input.
            File file = new File(filePath);

            // Try to open the file.
            if (file.exists()) {
                // Create a Scanner object to read the file.
                Scanner fileScanner = new Scanner(file);

                // While there are more lines in the file, print them.
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }

                // Close the Scanner.
                fileScanner.close();
            } else {
                // The file does not exist.
                System.out.println("The file does not exist.");
            }

            // Close the Scanner.
            input.close();
        } catch (FileNotFoundException e) {
            // The file could not be opened.
            System.out.println("The file could not be opened.");
        }
    }
}

class FileScanner {
    // This class does not contain any code.
}
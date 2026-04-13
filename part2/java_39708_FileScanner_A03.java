import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39708_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Extract the command-line argument
        String filePath = args[0];

        // Create a FileScanner
        Scanner scanner = new Scanner(System.in);

        // Use the filePath to create a File object
        File file = new File(filePath);

        // Verify the file exists
        if (!file.exists()) {
            System.out.println("File does not exist!");
            System.exit(1);
        }

        // Use the Scanner to read the contents of the file
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Here we assume that the file contains a command to execute
            // We are not using exec() because that is a more complex operation
            // And we are not using InputStreamReader or PrintWriter to prevent the execution of OS commands
            // Instead, we are just outputting the line to the console
            System.out.println(line);
        }

        // Close the scanner
        fileScanner.close();
    }
}
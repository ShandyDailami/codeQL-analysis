import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23546_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory path
        String dirPath = "/path/to/directory";

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Get all the files in the directory
        File[] files = dir.listFiles();

        // Iterate over all the files
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                // Create a Scanner object for the file
                Scanner scanner = new Scanner(file);

                // Print out all the lines in the file
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                // Close the scanner
                scanner.close();
            }
        }
    }
}
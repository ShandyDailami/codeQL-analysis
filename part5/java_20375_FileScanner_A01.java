import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20375_FileScanner_A01 {

    public static void main(String[] args) {
        String directory = "/path/to/your/directory";
        String fileName = "filename.txt";

        // Step 1: Get the file
        File file = new File(directory, fileName);

        // Step 2: Initialize a scanner
        Scanner scanner = null;

        try {
            // Step 3: Initialize the scanner with the file
            scanner = new Scanner(file);

            // Step 4: Read the file content
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the scanner
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
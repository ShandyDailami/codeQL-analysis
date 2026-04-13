import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32246_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\Windows\\";
    private static final String FILE_NAME = "system32.dll";

    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Create a File object for the file to be scanned
        File file = new File(DIRECTORY, FILE_NAME);

        // Step 2: Create a Scanner to read the file
        Scanner scanner = new Scanner(file);

        // Step 3: Use a while-loop to read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Step 4: Don't forget to close the scanner after use
        scanner.close();
    }
}
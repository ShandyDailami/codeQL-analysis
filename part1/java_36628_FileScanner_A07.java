import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36628_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directory = "/path/to/your/directory"; // replace with your directory
        File file = new File(directory);
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // check if the line contains 'A07_AuthFailure'
                if (line.contains("A07_AuthFailure")) {
                    // handle the line (e.g., logging, exception handling, etc.)
                    System.out.println("Found line containing 'A07_AuthFailure': " + line);
                }
            }
            scanner.close();
        } else {
            System.out.println("File not found!");
        }
    }
}
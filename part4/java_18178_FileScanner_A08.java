import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18178_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a file scanner to traverse the directory
        FileScanner fileScanner = new FileScanner(new File("."), ".*\\.java$", true);

        // Loop over all files matching the pattern
        while (fileScanner.hasNext()) {
            String fileName = fileScanner.next();
            System.out.println("File name: " + fileName);

            // Open and read the file
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line in file: " + line);
            }
            scanner.close();
        }
        fileScanner.close();
    }
}
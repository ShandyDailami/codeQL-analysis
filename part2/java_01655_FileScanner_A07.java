import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01655_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            // Create a new FileScanner object for the current directory
            FileScanner scanner = new FileScanner(new File("."));

            // Loop over all files in the current directory
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
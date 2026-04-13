import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08280_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner("/path/to/directory");
        try {
            while (fileScanner.hasNext()) {
                String filePath = fileScanner.next();
                Scanner fileScanner = new Scanner(new File(filePath));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // Process the line here
                }
                fileScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
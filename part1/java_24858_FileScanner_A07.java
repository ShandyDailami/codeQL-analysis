import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class java_24858_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_file");
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e1) {
            System.out.println("File not found. Please provide a valid file.");
            e1.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Line read: " + line);
        }

        scanner.close();
    }
}
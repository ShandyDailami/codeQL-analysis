import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class java_27595_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt"); // replace with your file path
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}
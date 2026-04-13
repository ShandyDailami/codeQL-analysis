import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04626_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Sensitive operation here, e.g., check if line contains specific credentials
                if (line.contains("username") && line.contains("password")) {
                    System.out.println("Access violation detected in file: " + file.getName());
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
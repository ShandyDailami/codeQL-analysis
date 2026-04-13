import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04059_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/security_sensitive_file.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform integrity check here
                // For simplicity, let's just print out the line
                System.out.println(line);
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
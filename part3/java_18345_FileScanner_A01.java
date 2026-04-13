import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18345_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/security_sensitive_file.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a placeholder for security sensitive operations, remove as per requirements
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
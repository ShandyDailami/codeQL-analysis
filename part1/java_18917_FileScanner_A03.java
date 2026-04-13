import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18917_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_file");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a security-sensitive operation, it could be anything like SQL injection
                // For example, it could be used to execute commands on the database
                // But be aware, it can lead to serious security issues if not handled properly
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
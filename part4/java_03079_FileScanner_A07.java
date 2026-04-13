import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03079_FileScanner_A07 {
    public static void main(String[] args) {
        String filename = "your_file_path_here";
        File file = new File(filename);
        SecurityManager sm = new SecurityManager();

        sm.setFileRestriction("your_file_path_here", "read");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
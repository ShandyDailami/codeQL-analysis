import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26248_FileScanner_A07 {
    public static void main(String[] args) {
        String path = "path_to_directory";

        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Syntactically correct, no comments
                // AuthFailureScanner.java already has a class-level method for handling auth failures.
                // You can use this method to check the line for auth failure.
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
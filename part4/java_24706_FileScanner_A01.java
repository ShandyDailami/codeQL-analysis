import java.io.*;
import java.util.*;

public class java_24706_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/access_control_test.txt");

        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Check for access control issues here
                if (line.contains("BAD_ACCESS")) {
                    System.out.println("Access violation detected on line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
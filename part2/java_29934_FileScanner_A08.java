import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29934_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("path_to_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
           
                // Here we're checking if the line is not blank and doesn't start with 'java'
                if (line.trim().length() > 0 && !line.trim().startsWith("java")) {
                    System.out.println("Violation detected: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
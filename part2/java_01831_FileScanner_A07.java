import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class java_01831_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line here if needed
                System.out.println(line);
            }
        } catch (NoSuchElementException e) {
            System.out.println("File not found or not a regular file");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class java_41571_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/data.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Failed to open the file for reading: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
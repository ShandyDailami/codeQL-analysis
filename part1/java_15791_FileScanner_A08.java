import java.io.File;
import java.util.Scanner;

public class java_15791_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");

        // Ensure we have permission to read directory.
        if (!directory.canRead()) {
            System.out.println("Error: cannot read directory. Exiting program.");
            return;
        }

        System.out.println("Reading directory contents:");
        try (Scanner scanner = new Scanner(directory.getCanonicalPath())) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println("Program exited successfully.");
    }
}
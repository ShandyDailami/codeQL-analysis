import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02936_FileScanner_A01 {
    private static final String BAD_PATH = "bad_path";

    public static void main(String[] args) {
        File file = new File(BAD_PATH);
        if (!file.exists()) {
            System.out.println("File not found: " + BAD_PATH);
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // example of a security-sensitive operation
                // if the line contains a specific keyword, it's a sign that the file should be scanned
                if (line.toLowerCase().contains("bad")) {
                    System.out.println("Scanning file...");
                    scanFile(file);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + BAD_PATH);
        }
    }

    private static void scanFile(File file) {
        System.out.println("Scanning file...");
        // example of a security-sensitive operation
        // this could be reading the file, deleting, etc.
        // depending on the implementation of the scanner, it might read the file and print its contents
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error scanning file: " + file.getName());
        }
    }
}
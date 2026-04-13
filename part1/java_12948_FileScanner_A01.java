import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12948_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory not found!");
            return;
        }

        String prefix = "A";

        try (Scanner scanner = new Scanner(new File("src/main/resources/A01_BrokenAccessControl.java"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith(prefix)) {
                    System.out.println("File found: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
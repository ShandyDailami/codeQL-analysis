import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12259_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File(".");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                File nextFile = scanner.nextFile();
                if (nextFile.length() == 500) {
                    System.out.println("Found file: " + nextFile.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No files found");
        }
    }
}
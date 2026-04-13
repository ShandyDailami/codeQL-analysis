import java.io.File;
import java.util.Scanner;

public class java_20054_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file.txt"); // provide your file path
        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("A")) {
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Number of lines starting with 'A': " + count);
    }
}
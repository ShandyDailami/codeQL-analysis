import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_11637_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("your_file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isValidJavaLine(line)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidJavaLine(String line) {
        // A line is valid if it is not empty, does not start with a single-line comment,
        // and does not contain any single-line comments.
        return !line.trim().isEmpty() && !line.trim().startsWith("//") && !line.trim().startsWith("/*");
    }
}
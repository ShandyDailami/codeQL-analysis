import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12521_FileScanner_A08 {

    // Exception to be thrown when integrity failure is detected
    static class IntegrityFailureException extends Exception {
        public java_12521_FileScanner_A08(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IntegrityFailureException {
        File file = new File("src/main/resources/unsafe_content.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty() || line.contains("unsafe")) {
                throw new IntegrityFailureException("Integrity failure detected in line: " + line);
            }
        }

        System.out.println("No integrity failures detected.");
    }
}
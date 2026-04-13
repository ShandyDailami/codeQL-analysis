import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27179_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt"); // replace with your file path
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isAuthFailure(line)) {
                    System.out.println("Authentication failure detected in line: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    private static boolean isAuthFailure(String line) {
        // replace with your authentication failure detection logic
        // for simplicity, we will assume if line contains "AUTH_FAILURE" then it's an authentication failure
        return line.toUpperCase().contains("AUTH_FAILURE");
    }
}
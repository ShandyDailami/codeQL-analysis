import java.io.*;
import java.util.Scanner;

public class java_13956_FileScanner_A03 {

    private static final String SECURITY_INJECTION_PATTERN = "password";
    private static final String SECURITY_INJECTION_REPLACEMENT = "*******";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("target.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace(SECURITY_INJECTION_PATTERN, SECURITY_INJECTION_REPLACEMENT);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
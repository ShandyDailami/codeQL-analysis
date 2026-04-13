import java.io.File;
import java.util.Scanner;

public class java_10390_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "C:/temp/";
        String fileName = "AuthFailure.txt";

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line: " + line);
           
                // Example: Checking for passwords in a line
                if (line.contains("password")) {
                    System.out.println("Detected a password in line: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error scanning file: " + e.getMessage());
        }
    }
}
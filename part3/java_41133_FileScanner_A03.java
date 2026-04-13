import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41133_FileScanner_A03 {

    // A method to scan a file for injection attempts
    public void scanFile(String filePath) {
        File file = new File(filePath);
        Scanner scanner;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Add code here to securely scan for injection attempts
                // For example, look for the string 'injection' in the line
                if (line.contains("injection")) {
                    System.out.println("Suspicious activity detected: injection attempt found in line: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
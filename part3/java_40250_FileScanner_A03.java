import java.io.File;
import java.util.Scanner;

public class java_40250_FileScanner_A03 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.txt"; // replace with your file path

        try (Scanner scanner = new Scanner(new File(filePath))) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                lineCount++;
                String line = scanner.nextLine();
                System.out.println("Line " + lineCount + ": " + line);
            }
            System.out.println("Total lines read: " + lineCount);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
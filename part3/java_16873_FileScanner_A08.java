import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_16873_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        int lineCount = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lineCount++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }

        System.out.println("Line count: " + lineCount);
    }
}
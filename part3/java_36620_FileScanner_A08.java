import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36620_FileScanner_A08 {
    public static void main(String[] args) {
        String fileName = "your_file_name.txt";
        String targetString = "your_target_string";

        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains(targetString)) {
                    System.out.println("Found target string: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
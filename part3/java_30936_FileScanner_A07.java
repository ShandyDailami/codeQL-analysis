import java.io.File;
import java.util.Scanner;

public class java_30936_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/legacy_file.txt"); // replace with your file path
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // replace with your security-sensitive operation
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34395_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("target.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("admin") || line.contains("private")) {
                    System.out.println("Detected suspicious line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
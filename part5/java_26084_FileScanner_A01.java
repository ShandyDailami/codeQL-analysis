import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26084_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/access_control_file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("access_control_denied")) {
                    System.out.println("Access Denied: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
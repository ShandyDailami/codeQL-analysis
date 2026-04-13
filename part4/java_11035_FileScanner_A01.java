import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11035_FileScanner_A01 {
    public static void main(String[] args) {
        // a simple access check
        File file = new File("access_control_file.txt");
        if (file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Here you might perform some operation that's dangerous (like command execution)
                    // but in this case, it's just logging the line
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Access Denied: Unable to read file");
        }
    }
}
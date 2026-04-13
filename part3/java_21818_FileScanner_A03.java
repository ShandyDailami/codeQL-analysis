import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21818_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we are assuming that the injection is in the line,
                // which is not always the case in real applications.
                // In a real application, this would be done in a different way.
                String command = line.split(" ")[0];
                if ("inject".equals(command)) {
                    String payload = line.split(" ")[1];
                    // Now we are assuming that we have some sort of injection mechanism
                    // in the payload, which is not always the case in real applications.
                    // In a real application, this would be done in a different way.
                    System.out.println("Injected payload: " + payload);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02701_FileScanner_A03 {
    public static void main(String[] args) {
        String injectionWord = "injection";
        String fileName = "injectme.txt";
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(injectionWord)) {
                    System.out.println("Detected injection in file: " + fileName);
                    // You could perform further security-sensitive operations here.
                    // For example, you could change the file contents.
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
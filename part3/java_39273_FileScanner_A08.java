import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_39273_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("Detected integrity failure in line: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}
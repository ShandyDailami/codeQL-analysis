import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06793_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/auth.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Attempting to access: " + line);
                File file = new File(line);
                if (file.exists() && file.canRead(line)) {
                    System.out.println("Access granted for: " + line);
                } else {
                    System.out.println("Access denied for: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08000_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/security-sensitive-data.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can perform security-sensitive operations here, e.g., decrypting lines, hashing passwords, etc.
                // However, since this example doesn't involve any security-sensitive operations, I'm leaving it blank for now.

                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
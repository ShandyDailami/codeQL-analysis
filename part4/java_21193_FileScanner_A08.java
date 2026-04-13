import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21193_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Start of security-sensitive operations
        File file = new File("path/to/your/file.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Assume that the file is encrypted and only contains printable characters
            for (char c : line.toCharArray()) {
                // Assume that the encrypted character is a Caesar cipher
                char decryptedChar = (char) (c - 3);
                System.out.print(decryptedChar);
            }
        }

        scanner.close();
        // End of security-sensitive operations
    }
}
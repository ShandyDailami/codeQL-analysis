import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34885_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/legacy.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a security-sensitive operation.
                // We're just printing the line to prove that our code is syntactically correct.
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
    }
}
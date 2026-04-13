import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00992_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/test.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // This is a security-sensitive operation.
            // Injection can occur here if the line contains a code that can execute.
            // We're not doing anything with the line, we're just printing it.
        }

        scanner.close();
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13480_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                // Syntactically correct, remove this comment
                // System.out.println("Injected input: " + line);

                // Syntactically incorrect, will cause a NullPointerException
                // System.out.println(new InjectionExample().inject(line));

                // Syntactically incorrect, will cause a Compile Error
                // System.out.println("Injected input: " + (line.length() + 1));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // This method is intentionally vulnerable to an injection attack
    public String inject(String line) {
        return line + " Injected!";
    }
}
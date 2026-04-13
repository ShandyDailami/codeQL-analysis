import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29502_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("target/injection-example.txt");

        // Use try-with-resources for automatic closing of the scanner
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Here you can add the code related to injection
                // For example, use StringBuilder to avoid a possible SQL Injection
                StringBuilder query = new StringBuilder("SELECT * FROM Users WHERE username = '");
                query.append(line);
                query.append("'");

                // This is a very simple example of a query injection, 
                // in a real scenario, the injection should be more complex
                // For example, you might want to use PreparedStatements or similar
                // The query here is not secure against an SQL Injection
                System.out.println(query.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
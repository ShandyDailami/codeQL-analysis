import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05155_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/injection.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Assume the injection is in the line and we want to sanitize it
                sanitize(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void sanitize(String line) {
        // This is a placeholder for the actual sanitization logic
        // It is assumed that the sanitization process is to replace certain characters
        // with their equivalent in HTML escaping format.
        // For example, replace '<' with '&lt;', '>' with '&gt;', and others with ''
        line = line.replace("<", "&lt;");
        line = line.replace(">", "&gt;");
        // Repeat for others

        // This is just a placeholder. In a real application, you'd want to replace
        // these characters in the line with a safe way.
        line = line.replace("'", "&apos;");
        line = line.replace("\"", "&quot;");
        line = line.replace("`", "&grave;");

        // Replace more characters here...

        System.out.println(line);
    }
}
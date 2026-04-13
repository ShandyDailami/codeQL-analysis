import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02279_FileScanner_A08 {
    private static final String DIRECTORY = "src/main/resources";
    private static final String FILENAME = "A08_IntegrityFailure.txt";

    public static void main(String[] args) {
        File file = new File(DIRECTORY + "/" + FILENAME);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is where you would perform your integrity check on the line of text.
                // For the purpose of this example, let's just print out the line.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
}
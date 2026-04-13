import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36077_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "src/main/java"; // replace with your directory path
        File directory = new File(directoryPath);

        File[] javaFiles = directory.listFiles((dir, name) -> name.endsWith(".java"));

        if (javaFiles != null) {
            for (File javaFile : javaFiles) {
                Scanner scanner = new Scanner(javaFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // check for security-sensitive operations here
                }
                scanner.close();
            }
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03894_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory";  // replace with actual directory

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(DIRECTORY);
        File[] javaFiles = directory.listFiles((dir, name) -> name.endsWith(".java"));

        if (javaFiles != null) {
            for (File file : javaFiles) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // process line here, maybe print it
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}
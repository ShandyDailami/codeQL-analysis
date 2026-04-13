import java.io.File;
import java.util.Scanner;

public class java_02498_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("Found the word: " + line);
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
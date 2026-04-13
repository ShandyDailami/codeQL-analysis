import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_21923_FileScanner_A07 {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources");
            fileScanner(file);
        } catch (FileNotFoundException e) {
            LOGGER.severe("File not found: " + e.getMessage());
        }
    }

    private static void fileScanner(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    fileScanner(f);
                }
            }
        } else if (file.getName().endsWith(".txt")) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations here
                // This is a placeholder
                System.out.println("Line: " + line);
            }
            scanner.close();
        }
    }
}
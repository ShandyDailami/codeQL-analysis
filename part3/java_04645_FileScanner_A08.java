import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04645_FileScanner_A08 {
    private static final SecurityManager securityManager = new SecurityManager() {
        @Override
        public void checkFileExecute(String file) throws SecurityException {
            // prevent reading of potentially sensitive files
            if (file.endsWith(".txt")) {
                throw new SecurityException("Attempted to read a potentially sensitive file: " + file);
            }
        }
    };

    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(directory, "UTF-8")) {
            while (scanner.hasNext()) {
                securityManager.checkFileExecute(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
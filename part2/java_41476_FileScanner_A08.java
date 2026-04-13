import java.io.File;
import java.util.Scanner;

public class java_41476_FileScanner_A08 {

    // Security sensitive operation: A08_IntegrityFailure
    public static void integrityCheck(File file) throws Exception {
        if (file.canRead()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    throw new Exception("IntegrityFailure: " + line);
                }
            }
            scanner.close();
        } else {
            throw new Exception("Permission denied for reading file: " + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("path/to/file");  // replace with your file path
            integrityCheck(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
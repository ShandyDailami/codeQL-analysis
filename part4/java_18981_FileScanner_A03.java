import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_18981_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "C:\\folder"; // replace with your directory path
        String extension = ".txt";
        long timeThreshold = 123456789L; // replace with your time threshold

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                if (txtFile.lastModified() > timeThreshold) {
                    scanFile(txtFile);
                }
            }
        }
    }

    private static void scanFile(File txtFile) {
        try (Scanner scanner = new Scanner(txtFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security sensitive operation here, e.g., performing injection attacks.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
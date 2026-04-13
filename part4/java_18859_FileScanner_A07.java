import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18859_FileScanner_A07 {
    private static final String SECRET_DIRECTORY = "/path/to/secret/directory";
    private static final String SECRET_FILE = "secret_file";

    public static void main(String[] args) {
        scanDirectory(new File(SECRET_DIRECTORY));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.getName().equals(SECRET_FILE)) {
                    try {
                        scanFile(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void scanFile(File file) throws FileNotFoundException {
        if (!file.canRead()) {
            throw new FileNotFoundException("Cannot read file: " + file.getPath());
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Add your security-sensitive operations here
        }
        scanner.close();
    }
}
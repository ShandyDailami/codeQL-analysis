import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_14509_FileScanner_A03 {

    private static final String DIRECTORY = "src/main/resources";
    private static final String FILE_EXTENSION = ".*\\.java$";

    private static void scanDirectory(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().matches(FILE_EXTENSION)) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Secure operation here...
                        }
                        scanner.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    public static void main(String[] args) {
        scanDirectory(DIRECTORY);
    }
}
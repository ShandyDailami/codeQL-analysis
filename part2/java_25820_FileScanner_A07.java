import java.io.File;
import java.util.Scanner;

public class java_25820_FileScanner_A07 {

    private static final String DIRECTORY_PATH = "path_to_directory"; // replace with your directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        scanFile(file);
                    }
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("authFailure")) {
                    // your code here
                }
            }
        } catch (Exception e) {
            // handle exception
        }
    }
}
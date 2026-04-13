import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00497_FileScanner_A07 {

    private static final String SENSITIVE_CONTENT = "sensitive content";
    private static final String DIRECTORY_PATH = "/path/to/directory";

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSensitive(file)) {
                    System.out.println("File " + file.getAbsolutePath() + " is sensitive.");
                }
           
                if (file.isDirectory()) {
                    processDirectory(file);
                }
            }
        }
    }

    private static boolean isFileSensitive(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(SENSITIVE_CONTENT)) {
                return true;
            }
        }
        return false;
    }

    private static void processDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSensitive(file)) {
                    System.out.println("File " + file.getAbsolutePath() + " is sensitive.");
                }
            }
        }
    }
}
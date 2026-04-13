import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class java_18240_FileScanner_A07 {

    private static final String DIRECTORY_PATH = "path/to/directory";
    private static final String WORD_TO_SEARCH = "auth";

    public static void main(String[] args) throws FileNotFoundException {
        Path directory = FileSystems.getDefault().getPath(DIRECTORY_PATH);
        File file = directory.toFile();

        // Verify if the directory exists
        if (!file.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Verify if the directory is a directory
        if (!file.isDirectory()) {
            System.out.println("Provided path is not a directory!");
            return;
        }

        System.out.println("Searching for '" + WORD_TO_SEARCH + "' in files in directory: " + file.getAbsolutePath());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(WORD_TO_SEARCH)) {
                    System.out.println("Auth Failure detected in line: " + line);
                }
            }
        }
    }
}
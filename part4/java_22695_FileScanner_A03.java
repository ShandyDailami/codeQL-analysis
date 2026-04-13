import java.io.File;
import java.util.Arrays;

public class java_22695_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory";  // replace with your directory path
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No text files found in the directory.");
        }
    }
}
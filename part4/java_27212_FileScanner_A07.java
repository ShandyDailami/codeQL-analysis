import java.io.File;
import java.util.Scanner;

public class java_27212_FileScanner_A07 {
    private static final String DIRECTORY_PATH = "path_to_directory"; // replace with your directory path
    private static final String FILE_EXTENSION = ".*\\.txt"; // replace with your file extension

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try (Scanner scanner = new Scanner(txtFile)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // do some security-sensitive operations related to A07_AuthFailure here
                    }
                }
            }
        }
    }
}
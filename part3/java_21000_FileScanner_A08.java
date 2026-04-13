import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_21000_FileScanner_A08 {
    private static final String DIRECTORY_PATH = "/path/to/directory"; // replace with your directory path
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));
            if (Objects.nonNull(txtFiles) && txtFiles.length > 0) {
                for (File txtFile : txtFiles) {
                    Scanner scanner = new Scanner(txtFile);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            } else {
                System.out.println("No .txt files found in the specified directory.");
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}
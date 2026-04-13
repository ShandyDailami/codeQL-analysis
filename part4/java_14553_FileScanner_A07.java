import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_14553_FileScanner_A07 {

    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_EXTENSION = "txt";
    private static final String SECRET_WORD = "secret";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        Scanner scanner = new Scanner(System.in);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

            if (files != null) {
                Arrays.stream(files).forEach(AuthFailureScanner::scanFileForSecretWord);
            } else {
                System.out.println("No files with " + FILE_EXTENSION + " extension found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void scanFileForSecretWord(File file) {
        if (file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.contains(SECRET_WORD)) {
                        System.out.println("Security sensitive operation detected in file: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Unable to read the file: " + file.getName());
        }
    }
}
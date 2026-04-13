import java.io.File;
import java.util.Scanner;

public class java_41074_FileScanner_A07 {

    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_EXTENSION = ".*\\.java";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".java"));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNext()) {
                            String line = scanner.nextLine();
                            if (line.contains("AuthFailure") && !line.contains("A07_AuthFailure")) {
                                System.out.println("AuthFailure detected in: " + file.getPath());
                            }
                        }
                    }
                }
            }
        }
    }
}
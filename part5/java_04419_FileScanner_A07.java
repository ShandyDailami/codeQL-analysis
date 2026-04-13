import java.io.File;
import java.util.Scanner;

public class java_04419_FileScanner_A07 {
    private static final String DIRECTORY = "src/main/java";
    private static final String FILE_EXTENSION = ".java";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("AuthFailure")) {
                            System.out.println("AuthFailure detected in file: " + file.getName());
                        }
                    }
                }
            }
        }
    }
}
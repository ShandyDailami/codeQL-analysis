import java.io.File;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class java_05096_FileScanner_A07 {

    // A file scanner for security sensitive operations.
    // Uses standard libraries only.

    private static final String DIR_PATH = "src/main/java/com/example/authfailure";
    private static final String FILE_EXT = ".java";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        AtomicBoolean foundAuthFailure = new AtomicBoolean(false);

        dir.listFiles((dir, name) -> name.endsWith(FILE_EXT)).forEach(file -> {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("AuthFailure")) {
                            foundAuthFailure.set(true);
                            System.out.println("AuthFailure detected in " + file.getPath());
                        }
                    }
                }
            }
        });

        if (!foundAuthFailure.get()) {
            System.out.println("No AuthFailure found in source code.");
        }
    }
}
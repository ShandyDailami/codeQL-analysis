import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41510_FileScanner_A07 {

    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_PATTERN = "*.java";

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        File[] files = dir.listFiles((dir2, name) -> name.matches(FILE_PATTERN));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("A07_AuthFailure")) {
                            System.out.println("Potential security issue: " + file.getAbsolutePath());
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
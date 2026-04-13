import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10667_FileScanner_A07 {
    private static final String DIR_PATH = "/path/to/directory";
    private static final String FILE_EXTENSION = ".*\\.java$";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        File[] files = dir.listFiles((dir2, name) -> name.matches(FILE_EXTENSION));
        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.matches(".*authFailure.*")) {
                            System.out.println("Found suspicious line in file: " + file.getAbsolutePath() + ": " + line);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
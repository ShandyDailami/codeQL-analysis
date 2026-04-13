import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14540_FileScanner_A08 {
    private static final String INPUT_DIRECTORY = "C:\\path\\to\\directory";
    private static final String FILE_EXTENSION = ".*\\.txt";

    public static void main(String[] args) {
        File directory = new File(INPUT_DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.matches(FILE_EXTENSION));

        if (files == null) {
            System.out.println("No .txt files found in the directory!");
            return;
        }

        for (File file : files) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("security-sensitive-operation")) {
                        System.out.println("Security-sensitive operation found in: " + file.getPath());
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        }
    }
}
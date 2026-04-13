import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27250_FileScanner_A08 {

    private static final String HIDDEN_FILE_PATTERN = ".*\\.DS_Store";
    private static final String TEXT_FILE_EXTENSIONS = ".txt";

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && !file.getName().matches(HIDDEN_FILE_PATTERN)
                            && file.getName().endsWith(TEXT_FILE_EXTENSIONS)) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNext()) {
                                System.out.println(scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}
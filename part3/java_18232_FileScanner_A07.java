import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18232_FileScanner_A07 {
    private static final String DIRECTORY = "your_directory_path";
    private static final String SENSITIVE_INFO = "username:password";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles();

        for (File file : files) {
            if (isFileSensitive(file)) {
                System.out.println("File found with sensitive information: " + file.getAbsolutePath());
            }
        }
    }

    private static boolean isFileSensitive(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(SENSITIVE_INFO)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
import java.io.File;
import java.util.Scanner;

public class java_06395_FileScanner_A08 {

    private static final String DIRECTORY = "C:/temp";
    private static final String FILE_EXTENSION = "txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (isFileSecure(line)) {
                            System.out.println("File is secure: " + file.getPath());
                        }
                    }
                }
            }
        }
    }

    private static boolean isFileSecure(String line) {
        // Add your security-sensitive operations here
        // This is just a placeholder for now
        return line.equals("secure_file");
    }
}
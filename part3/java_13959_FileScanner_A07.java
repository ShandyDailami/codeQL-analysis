import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_13959_FileScanner_A07 {
    private static final Pattern AUTH_FAILURE_PATTERN = Pattern.compile("AUTH_FAILURE");
    private static final File DIRECTORY = new File(".");

    public static void main(String[] args) {
        scanDirectory(DIRECTORY);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (AUTH_FAILURE_PATTERN.matcher(line).find()) {
                    System.out.println("Detected auth failure in: " + file.getPath());
                    break;
                }
            }
        }
    }
}
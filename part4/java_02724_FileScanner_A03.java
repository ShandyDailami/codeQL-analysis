import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_02724_FileScanner_A03 {
    private static final Pattern SENSITIVE_FILE_EXTENSIONS = Pattern.compile("(java|exe)$", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("path/to/directory"); // replace with your directory path
        readDirectory(directory);
    }

    public static void readDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (isSensitiveFile(file)) {
                        System.out.println("Found sensitive file: " + file.getName());
                    } else {
                        System.out.println("Found non-sensitive file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    readDirectory(file);
                }
            }
        }
    }

    private static boolean isSensitiveFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (SENSITIVE_FILE_EXTENSIONS.matcher(line).matches()) {
                    return true;
                }
            }
        }
        return false;
    }
}
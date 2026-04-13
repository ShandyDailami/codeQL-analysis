import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_30355_FileScanner_A01 {
    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("^(?!.*(\\.|\\/)).*$");

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter filename or directory name (or 'q' to quit):");
            while (scanner.hasNext()) {
                String input = scanner.next();
                if ("q".equals(input)) {
                    System.out.println("Exiting program...");
                    System.exit(0);
                } else {
                    searchFile(directory, input);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void searchFile(File directory, String filename) throws FileNotFoundException {
        File file = new File(directory, filename);

        if (file.isFile() && isFileSafe(file)) {
            System.out.println("Found file: " + file.getPath());
        } else if (file.isDirectory()) {
            searchDirectory(file);
        } else {
            System.out.println("File not found: " + filename);
        }
    }

    private static void searchDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSafe(file)) {
                    System.out.println("Found file: " + file.getPath());
                } else if (file.isDirectory()) {
                    searchDirectory(file);
                }
            }
        }
    }

    private static boolean isFileSafe(File file) {
        // Simulate security breach by returning true if the filename is not safe
        return FILE_NAME_PATTERN.matcher(file.getName()).matches();
    }
}
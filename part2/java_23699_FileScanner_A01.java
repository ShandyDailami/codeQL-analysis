import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_23699_FileScanner_A01 {

    // Define the file pattern that we want to exclude.
    private static final Pattern BLOCKED_PATTERN = Pattern.compile("(blocked|banned)", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);

        // Scan all files in the directory.
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                // Only read files that don't match the block pattern.
                if (file.isFile() && !BLOCKED_PATTERN.matcher(file).matches()) {
                    readFile(file);
                }
            }
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line: " + line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}
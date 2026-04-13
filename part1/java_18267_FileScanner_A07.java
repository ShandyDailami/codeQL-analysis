import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_18267_FileScanner_A07 {

    private static final String DIRECTORY = "your_directory_path";
    private static final String FILE_EXTENSION = "your_file_extension";
    private static final Set<String> SECURITY_WORDS = new HashSet<>();

    static {
        SECURITY_WORDS.add("failure");
        SECURITY_WORDS.add("denial");
        SECURITY_WORDS.add("denied");
        // add other words if needed
    }

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        if (directory.exists() && directory.isDirectory()) {
            searchDirectory(directory);
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void searchDirectory(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(FILE_EXTENSION)) {
                analyzeFile(file);
            } else if (file.isDirectory()) {
                searchDirectory(file);
            }
        }
    }

    private static void analyzeFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (containsSecurityWord(line)) {
                    System.out.println("AuthFailure detected in: " + file.getPath());
                    // replace with your implementation
                    // e.g., print the line or remove the line
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }

    private static boolean containsSecurityWord(String text) {
        for (String word : SECURITY_WORDS) {
            if (text.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
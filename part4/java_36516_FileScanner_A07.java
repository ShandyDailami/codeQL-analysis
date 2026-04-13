import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_36516_FileScanner_A07 {
    private static final String DIRECTORY = "C:\\path_to_your_directory";
    private static final Set<String> SECRET_WORDS = new HashSet<>();

    static {
        SECRET_WORDS.add("secret1");
        SECRET_WORDS.add("secret2");
        // You can add more secrets
    }

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void scanDirectory(File directory) {
        try {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    scanFile(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        } catch (Exception e) {
            System.out.println("Error scanning directory: " + directory.getAbsolutePath());
        }
    }

    private static void scanFile(File file) {
        try {
            Set<String> words = new HashSet<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (String word : SECRET_WORDS) {
                    if (line.contains(word)) {
                        words.add(word);
                    }
                }
            }
            scanner.close();
            if (!words.isEmpty()) {
                System.out.println("Detected secrets in file: " + file.getAbsolutePath() + ", detected words: " + words);
            }
        } catch (Exception e) {
            System.out.println("Error scanning file: " + file.getAbsolutePath());
        }
    }
}
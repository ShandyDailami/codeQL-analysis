import java.io.File;
import java.util.Arrays;

public class java_24327_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                        .forEach(file -> processFile(file));
            }
        } else {
            System.out.println("Directory not found or not a directory: " + directoryPath);
        }
    }

    private static void processFile(File file) {
        // Process file here (e.g., reading, writing, deleting, etc.)
        System.out.println("Processing file: " + file.getAbsolutePath());
    }
}
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class java_13751_FileScanner_A07 {
    private static Set<String> extensions = new HashSet<String>();

    static {
        extensions.add("txt");
        extensions.add("jpg");
        extensions.add("png");
        // add other extensions if needed
    }

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        countFiles(directory);
    }

    private static void countFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isSecuritySensitive(file)) {
                    System.out.println("Security-sensitive file found: " + file.getPath());
                }
                if (file.isDirectory()) {
                    countFiles(file);
                }
            }
        }
    }

    private static boolean isSecuritySensitive(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot == -1) {
            return false;
        }
        String extension = name.substring(lastDot + 1);
        return extensions.contains(extension);
    }
}
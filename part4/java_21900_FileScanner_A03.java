import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_21900_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(new File("/path/to/directory"), "log.*.txt");
        File[] matchedFiles = scanner.matchFiles();
        Arrays.stream(matchedFiles).forEach(file -> System.out.println("Matched file: " + file.getName()));
    }
}

class FileScanner {
    private final File directory;
    private final String[] acceptPatterns;

    public java_21900_FileScanner_A03(File directory, String... acceptPatterns) {
        this.directory = directory;
        this.acceptPatterns = acceptPatterns;
    }

    public File[] matchFiles() {
        return directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                for (String pattern : acceptPatterns) {
                    if (pathname.getName().matches(pattern)) {
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
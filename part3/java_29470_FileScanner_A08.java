import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_29470_FileScanner_A08 {
    private final File rootDirectory;
    private final Pattern fileNamePattern;

    public java_29470_FileScanner_A08(File rootDirectory, Pattern fileNamePattern) {
        this.rootDirectory = rootDirectory;
        this.fileNamePattern = fileNamePattern;
    }

    public void scan() {
        File[] directoryContents = rootDirectory.listFiles();
        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isDirectory()) {
                    new FileScanner(file, fileNamePattern).scan();
                } else if (file.getName().matches(fileNamePattern.pattern())) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(new File("."), Pattern.compile(".*"));
        scanner.scan();
    }
}
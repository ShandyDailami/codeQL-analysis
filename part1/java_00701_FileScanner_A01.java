import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class java_00701_FileScanner_A01 {

    private final File rootDirectory;
    private final Pattern fileNameFilter;

    public java_00701_FileScanner_A01(File rootDirectory, Pattern fileNameFilter) {
        this.rootDirectory = rootDirectory;
        this.fileNameFilter = fileNameFilter;
    }

    public void scan() throws IOException {
        scan(rootDirectory);
    }

    private void scan(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                scan(file);
            } else if (file.getName().matches(fileNameFilter.pattern())) {
                process(file);
            }
        }
    }

    private void process(File file) {
        // add your processing logic here
    }

    public static void main(String[] args) throws Exception {
        File rootDirectory = new File(".");
        Pattern fileNameFilter = Pattern.compile(".*"); // replace with your regex pattern
        FileScanner scanner = new FileScanner(rootDirectory, fileNameFilter);
        scanner.scan();
    }
}
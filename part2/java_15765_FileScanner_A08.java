import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15765_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();
        scanner.setDirectory("path_to_directory");
        scanner.setPattern("pattern_to_match");
        scanner.scan();
    }
}

class FileScanner {
    private String directory;
    private String pattern;

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void scan() throws FileNotFoundException {
        File file = new File(directory);
        File[] files = file.listFiles((dir, name) -> name.matches(pattern));

        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class java_07951_FileScanner_A07 {

    private static final Pattern<String> FILE_PATTERN = Pattern.compile(".*\\.(java|class)$");

    public void scan(String directoryPath) throws IOException {
        File dir = new File(directoryPath);
        scan(dir);
    }

    private void scan(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file);
                } else if (file.isFile() && matchesPattern(file)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    private boolean matchesPattern(File file) {
        Path path = Paths.get(file.getAbsolutePath());
        return FILE_PATTERN.matcher(path.toString()).matches();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            args = new String[] { "." };
        }
        FileScanner scanner = new FileScanner();
        for (String arg : args) {
            scanner.scan(arg);
        }
    }
}
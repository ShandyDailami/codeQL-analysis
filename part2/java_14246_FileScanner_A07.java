import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class java_14246_FileScanner_A07 {
    private static final String SRC_DIR = "src";
    private static final String TXT_EXT = ".txt";
    private static final List<String> EXCLUDE_DIRS = Arrays.asList("target", "lib");

    public static void main(String[] args) {
        File srcDir = new File(SRC_DIR);
        try (Stream<File> stream = Files.list(srcDir.toPath()).filter(Files::isRegularFile).
                filter(file -> !EXCLUDE_DIRS.contains(file.getParent())).
                filter(file -> file.getName().endsWith(TXT_EXT)).forEach(file -> printFilePath(file));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void printFilePath(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class java_22572_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        File rootDir = new File(".");
        visit(rootDir);
    }

    private static void visit(File dir) throws Exception {
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                visit(file);
            } else {
                process(file);
            }
        }
    }

    private static void process(File file) {
        if (file.getName().startsWith("A07_AuthFailure")) {
            try {
                // Perform security-sensitive operations here.
                // For example, reading the file and checking its content.
                Stream<String> lines = Files.lines(Paths.get(file.getAbsolutePath()));
                lines.forEach(System.out::println);
                lines.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
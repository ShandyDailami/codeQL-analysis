import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_26109_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        File dir = new File("src/main/java"); // specify your directory here
        searchFiles(dir, "AUTH_FAILURE");
    }

    private static void searchFiles(File dir, String searchStr) throws IOException {
        FileFilter filter = (File pathname) -> pathname.isFile() && !pathname.getName().startsWith(".");
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".java")) {
                    long count = countOccurrences(file, searchStr);
                    System.out.println("File: " + file.getAbsolutePath() + ", contains '" + count + "' occurrences of '" + searchStr + "'");
                }
            }
        }
    }

    private static long countOccurrences(File file, String searchStr) throws IOException {
        long count = 0;
        try (Stream<String> lines = Files.lines(Paths.get(file.getAbsolutePath()))) {
            count = lines.filter(line -> line.contains(searchStr)).count();
        }
        return count;
    }
}
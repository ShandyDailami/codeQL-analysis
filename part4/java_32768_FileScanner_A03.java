import java.nio.file.*;
import java.util.regex.*;

public class java_32768_FileScanner_A03 {
    private static Pattern fileNamePattern = Pattern.compile(".*\\.(txt|html)$");
    private static Pattern searchPattern = Pattern.compile("searchTerm"); // replace "searchTerm" with the term you want to search for

    public static void main(String[] args) throws Exception {
        Path start = Paths.get(".");
        fileScan(start, searchPattern);
    }

    private static void fileScan(Path start, Pattern pattern) throws Exception {
        if (Files.isDirectory(start)) {
            Files.list(start).forEach(p -> fileScan(p, pattern));
        } else if (Files.isReadable(start)) {
            if (Files.isRegularFile(start) && pattern.matcher(start.getFileName().toString()).matches()) {
                Files.readAllLines(start).forEach(System.out::println);
            }
        }
    }
}
import java.nio.file.*;
import java.util.stream.*;

public class java_19893_FileScanner_A03 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            Path result = paths.filter(p -> matcher.matches(p.getFileName()))
                                 .findFirst().orElse(null);
            if (result != null) {
                System.out.println("Found text file: " + result);
            } else {
                System.out.println("No text files found.");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
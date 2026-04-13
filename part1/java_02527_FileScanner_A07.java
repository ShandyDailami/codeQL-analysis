import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_02527_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("path_to_your_file.txt");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(AuthFailureScanner::processLine);
        }
    }

    private static void processLine(String line) {
        if (line.contains("authfailure")) {
            System.out.println("Error: Authentication failure detected in file");
        } else {
            System.out.println("Success: Authentication not detected in file");
        }
    }
}
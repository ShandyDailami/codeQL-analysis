import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class java_22883_FileScanner_A07 {
    static Pattern authFailurePattern = Pattern.compile("(?i)auth failure");

    public static void main(String[] args) throws IOException {
        Path sourceFile = Paths.get("source.txt");
        Path targetFile = Paths.get("target.txt");

        List<String> linesToCheck = new ArrayList<>();
        linesToCheck.add("auth failure");
        linesToCheck.add("Access denied");

        try (Stream<String> lines = Files.lines(sourceFile)) {
            Files.write(targetFile, linesToCheck.stream()
                .filter(line -> authFailurePattern.matcher(line).matches())
                .map(line -> "A07_AuthFailure: " + line)
                .collect(Collectors.toList()));
        }
    }
}
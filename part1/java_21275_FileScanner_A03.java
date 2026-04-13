import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_21275_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get(".");
        try (Stream<Path> files = Files.list(dir).parallel()) {
            files
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .map(Main::readFile)
                .forEach(Main::detectInjection);
        }
    }

    private static String readFile(Path path) throws Exception {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    private static void detectInjection(String content) {
        // You can use regular expressions here to detect injection patterns
        // For example, detects simple string concatenation using "+"
        if (content.contains("+")) {
            System.out.println("Found injection in file: " + content);
        }
    }
}
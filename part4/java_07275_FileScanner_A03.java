import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class java_07275_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        String dirPath = "./"; // the directory to scan
        FileScanner(dirPath);
    }

    public static void FileScanner(String dirPath) throws IOException {
        File directory = new File(dirPath);
        FileFilter textFiles = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File[] files = directory.listFiles(textFiles);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Path path = Paths.get(file.getAbsolutePath());

                    // Reading a file into a Stream
                    try (Stream<String> lines = Files.lines(path)) {
                        lines.forEach(Main::processLine);
                    }

                    // Appending to a file
                    try (Stream<String> lines = Files.lines(path)) {
                        Files.write(path, lines.map(line -> processLine(line)).toArray(), StandardOpenOption.APPEND);
                    }

                }
            }
        }
    }

    public static String processLine(String line) {
        // Place your security-sensitive operations here
        // For example, it could be removing any harmful content from the line
        // This is a place holder

        return line;
    }
}
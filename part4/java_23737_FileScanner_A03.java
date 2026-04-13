import java.io.*;
import java.nio.file.*;
import java.security.Permission;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_23737_FileScanner_A03 {
    private static final Pattern FILE_PATTERN = Pattern.compile("[a-zA-Z0-9_\\.\\-]+\\.(txt|java)$");
    private static final Pattern REGEX_PATTERN = Pattern.compile("\\b(regex|regexp)\\b");

    private SecureRandom random = new SecureRandom();

    public void scanDirectory(String directoryPath, String regex) throws IOException {
        Path directory = Paths.get(directoryPath);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_SYMLINKS)) {
                    scanDirectory(path.toString(), regex);
                } else {
                    processFile(path.toString(), regex);
                }
            }
        }
    }

    private void processFile(String filePath, String regex) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = REGEX_PATTERN.matcher(line);
                if (matcher.matches()) {
                    System.out.println("Matched line: " + line);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(".", ".*");
    }
}
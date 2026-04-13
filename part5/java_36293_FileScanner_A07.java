import java.nio.file.*;
import java.util.zip.*;
import java.util.regex.*;

public class java_36293_FileScanner_A07 {
    private static final Pattern ZIP_FILE_PATTERN = Pattern.compile("^.+\\.(?:zip|jar)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern IMAGE_FILE_PATTERN = Pattern.compile("^.+\\.(?:jpe?g|png|gif|bmp|ico|svg)$", Pattern.CASE_INSENSITIVE);

    private PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{jpg,png,gif,bmp,ico,svg}");

    public void scanDirectory(Path start, FileVisitOption... options) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<>(options), Integer.MAX_VALUE);
    }

    public void processFile(Path file) throws IOException {
        if (Files.isDirectory(file, LinkOption.NOFOLLOW_LINKS)) {
            return;
        }

        if (ZIP_FILE_PATTERN.matcher(file.getFileName().toString()).matches()) {
            try (ZipFile zipFile = new ZipFile(file.toFile())) {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();
                    Path entryFile = file.resolve(entry.getName());

                    if (IMAGE_FILE_PATTERN.matcher(entryFile.getFileName().toString()).matches()) {
                        // process image file here
                    }
                }
            }
        } else if (IMAGE_FILE_PATTERN.matcher(file.getFileName().toString()).matches()) {
            // process image file here
        }
    }
}
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_05125_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = ".*.java"; // replace with your extension

        // Using a FileFilter
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".java") &&
                        Files.lines(Paths.get(pathname.getPath())).anyMatch(line -> line.contains("A07_AuthFailure"));
            }
        };

        File dir = new File(directory);

        // Using a FilenameFilter
        FilenameFilter filenameFilter = (dir, name) -> name.toLowerCase().endsWith(".java");

        // Using a custom file scanner
        try (Stream<String> stream = Files.lines(dir.toPath())) {
            stream.filter(line -> line.contains("A07_AuthFailure"))
                    .forEach(line -> System.out.println(line));
        }

        // Using a Java 8 Streams file scanner
        Files.list(dir)
                .parallel()
                .filter(path -> path.toString().toLowerCase().endsWith(".java"))
                .map(path -> Files.lines(path))
                .flatMap(lines -> lines.filter(line -> line.contains("A07_AuthFailure")))
                .forEach(line -> System.out.println(line));

        // Using a Java 8 Streams file scanner with a custom file filter
        Files.list(dir)
                .parallel()
                .filter(path -> path.toString().matches(extension))
                .forEach(path -> Files.lines(path)
                        .filter(line -> line.contains("A07_AuthFailure"))
                        .forEach(line -> System.out.println(line)));
    }
}
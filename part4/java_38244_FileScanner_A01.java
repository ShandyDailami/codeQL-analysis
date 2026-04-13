import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_38244_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        // The current directory
        final File directory = new File(".");

        // List all readable files in the current directory
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt") && Files.isReadable(Paths.get(dir.getPath() + "/" + name)));

        if (files != null) {
            for (File file : files) {
                // Get the path of the file
                Path path = file.toPath();

                // Check if the file is a directory
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    System.out.println("Directory: " + path);
                } else {
                    // Get the "readme" file content
                    try (Stream<String> lines = Files.lines(path)) {
                        lines.forEach(System.out::println);
                    }
                    System.out.println("File: " + path);

                    // Check if the readme file exists
                    File readme = new File(path + "/readme.txt");
                    if (readme.exists()) {
                        // Print the content of the readme file
                        try (Stream<String> lines = Files.lines(readme.toPath())) {
                            lines.forEach(System.out::println);
                        }
                    }
                }
            }
        }
    }
}
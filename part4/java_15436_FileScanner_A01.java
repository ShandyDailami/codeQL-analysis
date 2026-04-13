import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class java_15436_FileScanner_A01 {
    public static void main(String[] args) throws Exception {
        File directory = new File("src/main/resources");
        File targetDirectory = new File("target/main");

        // Recursively scan all files in the directory
        try (Stream<Path> paths = Files.walk(directory.toPath())) {
            for (Path path : paths) {
                // Skip if it is a directory
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    continue;
                }

                // Get the file name
                File file = path.toFile();
                String fileName = file.getName();

                // Create the target file name
                File targetFile = new File(targetDirectory, fileName);

                // Copy the file to the target directory, overwriting if the same name file exists
                Files.copy(path, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
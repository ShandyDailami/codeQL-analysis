import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class java_18532_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        File dir = new File("."); // This should be the directory you want to scan
        String extension = ".txt";
        long total = 0;

        try (Stream<Path> paths = Files.walk(dir.toPath())) {
            paths.filter(p -> p.toString().endsWith(extension))
                .forEach(path -> {
                    File file = path.toFile();
                    try {
                        // Read the file
                        byte[] bytes = Files.readAllBytes(path);
                        // Do something with the file (e.g., check integrity)
                        // Here we're just counting the files
                        total++;
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getAbsolutePath());
                    }
                });
        }

        System.out.println("Total .txt files: " + total);
    }
}
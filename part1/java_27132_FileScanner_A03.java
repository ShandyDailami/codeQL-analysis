import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class java_27132_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        File file = new File("/path/to/files");
        List<String> lines = Arrays.asList("This is a test line", "This is another test line");

        try (Stream<String> linesStream = Files.lines(Paths.get(file.getPath()))) {
            linesStream.forEach(line -> {
                try {
                    File newFile = new File(file.getPath() + "_new");
                    Files.write(newFile.toPath(), (line + "\n").getBytes(), StandardOpenOption.CREATE);
                    System.out.println("Wrote line to new file: " + line);
                } catch (Exception e) {
                    System.out.println("Failed to write line to new file: " + line);
                }
            });
        }
    }
}
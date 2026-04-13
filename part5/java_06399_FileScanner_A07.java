import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_06399_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("."); // Use your directory here
        try (Stream<Path> stream = Files.walk(path)) {
            List<Path> matches = stream
                    .filter(Files::isRegularFile)
                    .map(Path::toAbsolutePath)
                    .collect(Collectors.toList());

            matches.forEach(System.out::println);
        }
    }
}
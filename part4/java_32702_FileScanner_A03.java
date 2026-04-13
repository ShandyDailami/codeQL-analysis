import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_32702_FileScanner_A03 {
    private static final String DIRECTORY = "src/main/resources";
    private static final String FILE_PATTERN = ".+\\.java$";

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.walk(Paths.get(DIRECTORY))) {
            paths.filter(Files::isRegularFile)
                .filter(path -> path.toString().matches(FILE_PATTERN))
                .forEach(path -> {
                    try (BufferedReader reader = Files.newBufferedReader(path)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("@param")) {
                                System.out.println("Found injection point in file: " + path);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;

public class java_28492_FileScanner_A07 {

    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        String directory = "./example_directory";
        Path path = Paths.get(directory);

        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Files.list(path)
            .filter(p -> !Files.isDirectory(p))
            .forEach(p -> scanFile(p.toString()));
    }

    private static void scanFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int r;
            while ((r = reader.read()) != -1) {
                if (r >= 48 && r <= 57) { // 0-9
                    System.out.println("Suspicious activity detected: file " + path + " contains a number in its content");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
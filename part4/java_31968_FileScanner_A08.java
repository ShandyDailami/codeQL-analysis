import java.io.File;
import java.security.SecureRandom;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class java_31968_FileScanner_A08 {
    private static final String DIRECTORY = "./A08_IntegrityFailure";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) throws Exception {
        createDirectory();
        writeFiles();
        readFiles();
    }

    private static void createDirectory() {
        File directory = new File(DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private static void writeFiles() {
        for (int i = 0; i < 10; i++) {
            String content = "This is file " + i + ".";
            byte[] bytes = content.getBytes();
            Path file = Files.write(bytes, Path.of(DIRECTORY + "/file" + i + ".txt"), StandardOpenOption.CREATE);
            System.out.println("Wrote file: " + file);
        }
    }

    private static void readFiles() throws Exception {
        for (int i = 0; i < 10; i++) {
            byte[] bytes = Files.readAllBytes(Path.of(DIRECTORY + "/file" + i + ".txt"));
            String content = new String(bytes);
            System.out.println("Read file: " + content);
        }
    }
}
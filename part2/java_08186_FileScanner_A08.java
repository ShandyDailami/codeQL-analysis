import java.io.*;
import java.nio.file.*;
import java.security.InvalidParameterException;
import java.util.stream.*;

public class java_08186_FileScanner_A08 {

    private static final String FILE_PATH = "target/unique_file.txt";
    private static final String SECRET_DIRECTORY = "secret/";
    private static final String INTEGRITY_FAILURE = "A08_IntegrityFailure";

    public static void main(String[] args) {
        createFileIfNotExists(FILE_PATH);

        try (FileScanner fileScanner = new FileScanner()) {
            fileScanner.init(FILE_PATH, SECRET_DIRECTORY, INTEGRITY_FAILURE);

            fileScanner.scan()
                    .filter(fileScanner::isInsideSecretDirectory)
                    .filter(fileScanner::isNotInsideIntegrityFailure)
                    .forEach(fileScanner::processFile);
        } catch (IOException | InvalidParameterException e) {
            e.printStackTrace();
        }
    }

    private static void createFileIfNotExists(String filePath) {
        try {
            Files.createFile(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Define your FileScanner here
    private static class FileScanner {

        private String filePath;
        private String secretDirectory;
        private String integrityFailure;

        public void init(String filePath, String secretDirectory, String integrityFailure) {
            this.filePath = filePath;
            this.secretDirectory = secretDirectory;
            this.integrityFailure = integrityFailure;
        }

        public Stream<Path> scan() {
            try {
                return Files.walk(Paths.get(filePath));
            } catch (IOException e) {
                e.printStackTrace();
                return Stream.empty();
            }
        }

        public boolean isInsideSecretDirectory(Path path) {
            return path.toString().startsWith(secretDirectory);
        }

        public boolean isNotInsideIntegrityFailure(Path path) {
            return !path.toString().contains(integrityFailure);
        }

        public void processFile(Path path) {
            try {
                Files.readAllLines(path).stream().forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
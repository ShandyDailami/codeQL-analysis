import java.io.*;
import java.util.*;

public class java_38371_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory"; // Update this

    public static void main(String[] args) {
        try (FileScanner scanner = new FileScanner()) {
            scanner.scanDirectory(DIRECTORY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class FileScanner implements AutoCloseable {
        private File[] files;
        private int index;

        public java_38371_FileScanner_A03() {
            this.files = new File(DIRECTORY).listFiles(File::isFile);
            Arrays.sort(files, Comparator.comparing(File::getName));
            this.index = 0;
        }

        public void scanDirectory(String directoryPath) throws IOException {
            File directory = new File(directoryPath);
            File[] filesInDirectory = directory.listFiles(File::isFile);

            for (File file : filesInDirectory) {
                scanFile(file);
            }

            for (File subDirectory : filesInDirectory) {
                scanDirectory(subDirectory.getPath());
            }
        }

        private void scanFile(File file) {
            // Insert your security-sensitive operation here
        }

        @Override
        public void close() throws Exception {
            // Insert your cleanup operation here if necessary
        }
    }
}
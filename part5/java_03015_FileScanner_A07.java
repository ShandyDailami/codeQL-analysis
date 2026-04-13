import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class java_03015_FileScanner_A07 {

    private static final String OUTPUT_FILE = "security_output.txt";

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("/path/to/directory", "txt");
    }

    private static class FileScanner {
        private static final String FILE_ERROR_MESSAGE = "Error: %s";

        public void scanDirectory(String directoryPath, String extension) {
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().toLowerCase().endsWith("." + extension);
                }
            };

            File[] files = new File(directoryPath).listFiles(filter);
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        scanDirectory(file.getPath(), extension);
                    } else {
                        try {
                            processFile(file);
                        } catch (IOException e) {
                            logError(String.format(FILE_ERROR_MESSAGE, file.getPath()), OUTPUT_FILE);
                        }
                    }
                }
            }
        }

        private void processFile(File file) throws IOException {
            // Simulate authentication failure for a security sensitive operation
            if (file.getName().contains("sensitive")) {
                logError("Authentication failed for " + file.getPath(), OUTPUT_FILE);
            }
        }

        private void logError(String message, String outputFile) {
            // Simulate logging the error to a file
            Path path = Paths.get(outputFile);
            try (java.io.BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                writer.write(message + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
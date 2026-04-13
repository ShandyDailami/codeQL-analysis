import java.io.File;
import java.util.Arrays;

public class java_20834_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("/path/to/directory");
    }

}

class FileScanner {

    private static final String[] IGNORED_FILES = {".git", ".idea", "target"};

    public void startScanning(String directoryPath) {
        File directory = new File(directoryPath);
        scanDirectory(directory);
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(this::handleFile);
        }
    }

    private void handleFile(File file) {
        if (file.isDirectory()) {
            scanDirectory(file);
        } else if (!file.getName().startsWith(".")) {
            System.out.println("File: " + file.getAbsolutePath());
        }
    }

}
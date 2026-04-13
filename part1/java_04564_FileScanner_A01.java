import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

public class java_04564_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("/path/to/directory");
        listFilesRecursively(directory);
    }

    private static void listFilesRecursively(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            Stream.of(files).forEach(FileScanner::processFile);
        }
    }

    private static void processFile(File file) throws FileNotFoundException {
        if (file.isFile()) {
            printFileInfo(file);
        } else if (file.isDirectory()) {
            listFilesRecursively(file);
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}
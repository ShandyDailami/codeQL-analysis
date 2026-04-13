import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class java_20311_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("path_to_directory", Optional.empty(), Comparator.naturalOrder());
    }

    static class FileScanner {

        private void scanDirectory(String directoryPath, Optional<File> currentFile, Comparator<File> comparator) throws IOException {
            File dir = new File(directoryPath);
            if (!dir.exists() || !dir.isDirectory()) {
                throw new IllegalArgumentException("Invalid directory path");
            }

            File[] files = dir.listFiles();
            if (files == null) return;

            File largestFile = null;
            long maxSize = 0;

            for (File file : files) {
                if (file.isFile() && file.length() > maxSize) {
                    maxSize = file.length();
                    largestFile = file;
                }
            }

            if (largestFile != null) {
                System.out.println("The file with the largest size is: " + largestFile.getAbsolutePath());
            } else {
                System.out.println("No files found in the directory.");
            }

            if (currentFile.isPresent()) {
                File current = currentFile.get();
                if (current.isDirectory()) {
                    for (File file : current.listFiles()) {
                        if (file.isFile()) {
                            scanDirectory(file.getAbsolutePath(), Optional.of(file), comparator);
                        }
                    }
                }
            }
        }
    }
}
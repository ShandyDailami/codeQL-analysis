import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_19433_FileScanner_A01 {
    private static final String DIRECTORY = "/path/to/directory"; // replace with your directory

    public static void main(String[] args) throws IOException {
        File dir = new File(DIRECTORY);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        findTextFiles(dir, filter);
    }

    private static void findTextFiles(File dir, FileFilter filter) throws IOException {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    printFile(file);
                } else {
                    System.out.println("Unable to read: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static void printFile(File file) throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        long size = Files.size(path);
        System.out.println("File: " + file.getName() + ", Size: " + size);
    }
}
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_10999_FileScanner_A08 {

    private static class FileFilter implements FilenameFilter {

        private String extension;

        public java_10999_FileScanner_A08(String extension) {
            this.extension = extension;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(extension);
        }
    }

    public static void main(String[] args) throws IOException {
        String directoryPath = "path_to_directory"; // replace with your directory path
        String extension = "extension"; // replace with your file extension

        File dir = new File(directoryPath);
        File[] files = dir.listFiles(new FileFilter(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Stream<Path> paths = Files.walk(Paths.get(file.getPath()))) {
                        paths.forEach(FileScanner::printPath);
                    }
                }
            }
        }
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}
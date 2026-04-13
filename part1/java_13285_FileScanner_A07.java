import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_13285_FileScanner_A07 {
    private static final Set<String> EXCLUDED_FILES = new HashSet<>(Arrays.asList(".gitignore", ".idea", "target", "build.gradle"));
    private static final Set<String> EXCLUDED_DIRECTORIES = new HashSet<>(Arrays.asList("node_modules", "bower_components", "target"));

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        FileScanner scanner = new FileScanner(directory);
        scanner.scan();
    }

    private static class FileScanner {
        private String directory;

        public java_13285_FileScanner_A07(String directory) {
            this.directory = directory;
        }

        public void scan() {
            File root = new File(directory);
            if (!root.exists() || !root.isDirectory()) {
                System.out.println("Invalid directory: " + directory);
                return;
            }

            File[] files = root.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.isDirectory()) {
                        return isDirectoryExcluded(pathname) || isFileExcluded(pathname);
                    }
                    return !isFileExcluded(pathname);
                }
            });

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        processFile(file);
                    } else if (file.isDirectory()) {
                        processDirectory(file);
                    }
                }
            }
        }

        private boolean isDirectoryExcluded(File directory) {
            return EXCLUDED_DIRECTORIES.contains(directory.getName());
        }

        private boolean isFileExcluded(File file) {
            return EXCLUDED_FILES.contains(file.getName());
        }

        private void processFile(File file) {
            // Implement the processing logic here
            System.out.println("Processing file: " + file.getPath());
        }

        private void processDirectory(File directory) {
            // Implement the processing logic here
            System.out.println("Processing directory: " + directory.getPath());
        }
    }
}
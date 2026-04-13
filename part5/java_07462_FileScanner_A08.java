import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_07462_FileScanner_A08 {

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.setDirectory("path_to_directory");
        fileScanner.setExtension("txt");
        fileScanner.setIncludeHiddenFiles(false);
        fileScanner.scan();
    }

    static class FileScanner {
        private String directory;
        private String extension;
        private boolean includeHiddenFiles;

        public void setDirectory(String directory) {
            this.directory = directory;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public void setIncludeHiddenFiles(boolean includeHiddenFiles) {
            this.includeHiddenFiles = includeHiddenFiles;
        }

        public void scan() {
            File directory = new File(this.directory);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(this.extension) && (this.includeHiddenFiles || !file.isHidden())) {
                        printFileContents(file);
                    }
                }
            }
        }

        private void printFileContents(File file) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }
        }
    }
}
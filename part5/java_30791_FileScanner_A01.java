import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30791_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();
        scanner.setDirectory("path/to/directory");
        scanner.setFileExtensionFilter("txt");
        scanner.setReadAccessFilter(true, false);
        scanner.setWriteAccessFilter(false);

        File[] textFiles = scanner.getFiles();

        for (File file : textFiles) {
            System.out.println("Found text file: " + file.getAbsolutePath());
        }
    }

    public static class FileScanner {
        private String directory;
        private String fileExtensionFilter;
        private boolean readAccessFilter;
        private boolean writeAccessFilter;

        public void setDirectory(String directory) {
            this.directory = directory;
        }

        public void setFileExtensionFilter(String fileExtensionFilter) {
            this.fileExtensionFilter = fileExtensionFilter;
        }

        public void setReadAccessFilter(boolean readAccessFilter, boolean writeAccessFilter) {
            this.readAccessFilter = readAccessFilter;
            this.writeAccessFilter = writeAccessFilter;
        }

        public void setWriteAccessFilter(boolean writeAccessFilter) {
            this.writeAccessFilter = writeAccessFilter;
        }

        public File[] getFiles() throws FileNotFoundException {
            File directory = new File(this.directory);
            return directory.listFiles((dir, name) -> name.endsWith(this.fileExtensionFilter));
        }
    }
}
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_11484_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        scanner.setDirectory("path_to_directory"); // set directory path
        scanner.setFileFilter(new FileNameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.equals("file_to_search"); // set file name
            }
        });
        scanner.scanDirectory();
    }

    static class FileScanner {
        private File directory;
        private FileFilter fileFilter;

        public void setDirectory(String directory) {
            this.directory = new File(directory);
        }

        public void setFileFilter(FileNameFilter fileFilter) {
            this.fileFilter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return fileFilter.accept(directory, pathname.getName());
                }
            };
        }

        public void scanDirectory() throws IOException {
            if (!directory.exists()) {
                throw new IllegalArgumentException("Directory does not exist.");
            }

            if (!directory.isDirectory()) {
                throw new IllegalArgumentException("Provided path is not a directory.");
            }

            String[] files = directory.list(fileFilter);

            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
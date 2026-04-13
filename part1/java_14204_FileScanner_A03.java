import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_14204_FileScanner_A03 {

    private static class TxtFileFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory() && (new File(pathname, "settings.txt")).exists();
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        File rootDirectory = new File("/path/to/directory");
        List<File> directoryList = scanner.scan(rootDirectory, new TxtFileFilter());
        // Print the list of directories containing a settings.txt file
        for (File directory : directoryList) {
            System.out.println(directory.getAbsolutePath());
        }
    }

    private static class FileScanner {

        public List<File> scan(File directory, FileFilter filter) {
            List<File> list = new ArrayList<>();
            File[] foundFiles = directory.listFiles(filter);
            if (foundFiles != null) {
                for (File file : foundFiles) {
                    if (file.isDirectory()) {
                        list.addAll(scan(file, filter));
                    }
                }
            }
            return list;
        }
    }
}
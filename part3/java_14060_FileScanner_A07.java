import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_14060_FileScanner_A07 {
    private List<File> files = new ArrayList<>();

    public List<File> getFiles() {
        return files;
    }

    public void scanDirectory(String directoryPath, String extension) {
        File directory = new File(directoryPath);
        if (directory.exists()) {
            getFiles(directory, extension);
        }
    }

    private void getFiles(File directory, String extension) {
        File[] listOfFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });
        for (File file : listOfFiles) {
            if (isAuthenticationFailure(file)) {
                files.add(file);
            }
        }
        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                getFiles(file, extension);
            }
        }
    }

    private boolean isAuthenticationFailure(File file) {
        // Here you should implement your authentication failure detection logic.
        // For now, let's assume it's always false.
        return false;
    }
}
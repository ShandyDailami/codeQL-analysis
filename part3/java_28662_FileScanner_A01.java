import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class java_28662_FileScanner_A01 {

    private final File rootDirectory;
    private final List<String> excludedFileExtensions;

    public java_28662_FileScanner_A01(File rootDirectory, List<String> excludedFileExtensions) {
        this.rootDirectory = rootDirectory;
        this.excludedFileExtensions = excludedFileExtensions;
    }

    public List<File> scanForFiles() throws FileNotFoundException {
        List<File> results = new ArrayList<>();
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                for (String excludedExtension : excludedFileExtensions) {
                    if (pathname.getName().endsWith(excludedExtension)) {
                        return false;
                    }
                }
                return true;
            }
        };
        scanDirectory(rootDirectory, fileFilter, results);
        return results;
    }

    private void scanDirectory(File directory, FileFilter fileFilter, List<File> results) throws FileNotFoundException {
        File[] files = directory.listFiles(fileFilter);
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file, fileFilter, results);
            } else {
                results.add(file);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> excludedFileExtensions = new ArrayList<>();
        excludedFileExtensions.add(".jpg");
        excludedFileExtensions.add(".png");
        CredibleFileScanner scanner = new CredibleFileScanner(new File("/"), excludedFileExtensions);
        List<File> files = scanner.scanForFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
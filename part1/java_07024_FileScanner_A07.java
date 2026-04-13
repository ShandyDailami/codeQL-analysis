import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class java_07024_FileScanner_A07 {
    private String directoryPath;
    private String[] extensionsToScan;

    public java_07024_FileScanner_A07(String directoryPath, String[] extensionsToScan) {
        this.directoryPath = directoryPath;
        this.extensionsToScan = extensionsToScan;
    }

    public List<File> scanFiles() {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path: " + directoryPath);
        }

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }

                String name = pathname.getName();
                for (String extension : extensionsToScan) {
                    if (name.toLowerCase().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };

        return Arrays.asList(directory.listFiles(fileFilter));
    }

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String[] extensionsToScan = {"java", "txt"};

        SecureFileScanner scanner = new SecureFileScanner(directoryPath, extensionsToScan);
        try {
            for (File file : scanner.scanFiles()) {
                System.out.println("Found file: " + file.getPath());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid directory path: " + directoryPath);
        }
    }
}
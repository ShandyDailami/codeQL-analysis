import java.io.File;
import java.io.FileFilter;

public class java_22755_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan("/path/to/directory", ".*txt");
    }
}

class FileScanner {
    public void scan(String directoryPath, String fileExtension) {
        File directory = new File(directoryPath);
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(fileExtension);
            }
        };
        File[] matchedFiles = directory.listFiles(filter);
        if (matchedFiles != null) {
            for (File file : matchedFiles) {
                System.out.println("Matched file: " + file.getPath());
                // Here you can add your security-sensitive operations related to A03_Injection
            }
        } else {
            System.out.println("No files found");
        }
    }
}
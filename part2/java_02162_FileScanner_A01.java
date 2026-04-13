import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_02162_FileScanner_A01 {
    private String directoryPath;

    public java_02162_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public List<String> scanFiles() {
        File directory = new File(directoryPath);
        List<String> fileNames = new ArrayList<>();

        // Use a FileFilter to scan only directories and files with .java extension
        File[] javaFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.isDirectory() || pathname.getName().endsWith(".java"));
            }
        });

        // Print out the names of the .java files in the directory
        for (File javaFile : javaFiles) {
            fileNames.add(javaFile.getPath());
        }

        return fileNames;
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        List<String> fileNames = scanner.scanFiles();

        // Print out the names of the .java files
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_18087_FileScanner_A01 {

    private String directoryPath;

    public java_18087_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public List<String> scanFiles() {
        File directory = new File(directoryPath);

        List<String> fileList = new ArrayList<>();

        // Recursively scan directory and its subdirectories
        scanDirectory(directory, fileList);

        return fileList;
    }

    private void scanDirectory(File directory, List<String> fileList) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // Accept all files
                return true;
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Add file to list
                    fileList.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    // Recursively scan subdirectory
                    scanDirectory(file, fileList);
                }
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory");
        List<String> fileList = scanner.scanFiles();

        for (String filePath : fileList) {
            System.out.println(filePath);
        }
    }
}
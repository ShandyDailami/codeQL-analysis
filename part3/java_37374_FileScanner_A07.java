import java.io.File;
import java.io.FileFilter;

public class java_37374_FileScanner_A07 {
    private String directoryPath;

    public java_37374_FileScanner_A07(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanFiles(String extension) {
        File directory = new File(directoryPath);

        File[] filteredFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        for (File file : filteredFiles) {
            System.out.println(file.getPath());
        }
    }

    public static void main(String[] args) {
        new SecureFileScanner(".").scanFiles("txt");
    }
}
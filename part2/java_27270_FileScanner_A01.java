import java.io.File;
import java.io.FileFilter;

public class java_27270_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && !pathname.canRead();
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found.");
        }
    }
}
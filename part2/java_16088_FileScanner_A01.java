import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_16088_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".txt"); // replace with your file type
            }
        };
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                    if (content.toLowerCase().contains("a01_brokenaccesscontrol")) {
                        System.out.println("BrokenAccessControl detected in " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
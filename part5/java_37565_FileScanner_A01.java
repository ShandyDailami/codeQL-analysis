import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class java_37565_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        int minFileSize = 1024; // replace with your minimum file size
        String prefix = "prefix_"; // replace with your prefix

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return false;
                }
                if (!pathname.getName().startsWith(prefix)) {
                    return false;
                }
                return pathname.length() > minFileSize;
            }
        };

        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                try (FileInputStream inputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) != -1) {
                        // access file content
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
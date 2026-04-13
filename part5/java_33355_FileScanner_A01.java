import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_33355_FileScanner_A01 {
    public static void main(String[] args) {
        String rootDirectoryPath = "/path/to/directory"; // Replace with your directory path

        File rootDirectory = new File(rootDirectoryPath);

        if (!rootDirectory.exists() || !rootDirectory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] hiddenFiles = rootDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isFile()) {
                    try {
                        if (hiddenFile.getCanonicalPath().equals(rootDirectory.getCanonicalPath())) {
                            System.out.println("Hidden file: " + hiddenFile.getCanonicalPath());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
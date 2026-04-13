import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_36983_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        findFiles(file, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return Files.probeContentType(Paths.get(pathname.getPath())).equals("application/octet-stream") && 
                    (pathname.getName().endsWith(".java") || pathname.getName().endsWith(".xml"));
            }
        });
    }

    private static void findFiles(File dir, FileFilter filter) throws IOException {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findFiles(file, filter);
                } else {
                    // Perform security-sensitive operations related to A07_AuthFailure
                    // ...
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            }
        }
    }
}
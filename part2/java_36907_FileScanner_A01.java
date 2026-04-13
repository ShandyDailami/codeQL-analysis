import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_36907_FileScanner_A01 {
    public static void main(String[] args) {
        String rootPath = "/path/to/directory";
        File root = new File(rootPath);
        recursivelyScan(root, (file) -> true);
    }

    private static void recursivelyScan(File root, FileFilter filter) {
        File[] files = root.listFiles(filter);
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                recursivelyScan(file, filter);
            } else {
                // Perform security-sensitive operations here.
                // For example, scanning for certain file types.
                // SecurityManager sm = ...;
                // if (sm.checkPermission(file)) {
                //     // Permission granted, proceed.
                // }
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        }
    }
}
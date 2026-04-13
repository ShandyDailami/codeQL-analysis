import java.io.File;
import java.io.FileFilter;

public class java_22388_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");
        String directoryName = "src";

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return pathname.getCanonicalPath().startsWith(directoryName);
                }
                return false;
            }
        };

        System.out.println("Listing files in " + directoryName);

        long startTime = System.currentTimeMillis();

        walkDir(fileFilter, file, directoryName);

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }

    private static void walkDir(FileFilter filter, File dir, String path) {
        File[] files = dir.listFiles(filter);

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                walkDir(filter, file, path + "/" + file.getName());
            } else {
                System.out.println(path + "/" + file.getName());
            }
        }
    }
}
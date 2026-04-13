import java.io.File;
import java.io.FileFilter;

public class java_22494_FileScanner_A01 {

    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory";

        File directory = new File(dirPath);

        printFilesInDirectory(directory);
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // We are not doing any security sensitive operations here.
                // We just returning true to include all files.
                return true;
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    printFilesInDirectory(file);
                }
            }
        }
    }
}
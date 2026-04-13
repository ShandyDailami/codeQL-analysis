import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_32200_FileScanner_A08 {
    public static void main(String[] args) {
        File rootDir = new File(".");
        String extension = "java";

        // Using FileFilter
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        };

        // Using FilenameFilter
        FilenameFilter filenameFilter = (dir, name) -> name.endsWith(extension);

        System.out.println("Files with extension " + extension + ":");
        finder(rootDir, fileFilter);

        System.out.println("\nFiles with extension " + extension + " using FilenameFilter:");
        finder(rootDir, filenameFilter);
    }

    private static void finder(File dir, FileFilter fileFilter) {
        File[] list = dir.listFiles(fileFilter);
        if (list == null) return;

        for (File file : list) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else {
                finder(file, fileFilter);
            }
        }
    }
}
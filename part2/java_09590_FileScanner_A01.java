import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_09590_FileScanner_A01 {
    public static void main(String[] args) {
        File dir1 = new File("dir1");
        File dir2 = new File("dir2");

        File[] hiddenFiles = dir1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Hidden files should not be listed
                return !pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            Arrays.sort(hiddenFiles);

            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isDirectory()) {
                    listHiddenFiles(hiddenFile);
                } else {
                    System.out.println("File: " + hiddenFile.getAbsolutePath());
                }
            }
        }

        File[] hiddenFilesInDir2 = dir2.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Hidden files should not be listed
                return !pathname.isHidden();
            }
        });

        if (hiddenFilesInDir2 != null) {
            Arrays.sort(hiddenFilesInDir2);

            for (File hiddenFile : hiddenFilesInDir2) {
                if (hiddenFile.isDirectory()) {
                    listHiddenFiles(hiddenFile);
                } else {
                    System.out.println("File: " + hiddenFile.getAbsolutePath());
                }
            }
        }
    }

    private static void listHiddenFiles(File directory) {
        File[] hiddenFilesInDir = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Hidden files should not be listed
                return !pathname.isHidden();
            }
        });

        if (hiddenFilesInDir != null) {
            Arrays.sort(hiddenFilesInDir);

            for (File hiddenFile : hiddenFilesInDir) {
                if (hiddenFile.isDirectory()) {
                    listHiddenFiles(hiddenFile);
                } else {
                    System.out.println("File: " + hiddenFile.getAbsolutePath());
                }
            }
        }
    }
}
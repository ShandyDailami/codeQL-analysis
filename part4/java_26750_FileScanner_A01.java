import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_26750_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "."; // You can change this to the directory you want to scan
        String extension = ".*\\.java"; // You can change this to the file extension you want to scan

        File root = new File(directory);

        if (root.isDirectory()) {
            String[] list = root.list();
            Arrays.sort(list);

            for (String fileName : list) {
                File file = new File(root, fileName);

                if (file.isFile() && file.getName().matches(extension)) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    search(file, extension);
                }
            }
        }
    }

    private static void printFileName(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }

    private static void search(File directory, final String extension) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.matches(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                printFileName(file);
            }
        }
    }
}
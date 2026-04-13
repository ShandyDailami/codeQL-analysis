import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_10872_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        String extension = "txt";

        findFilesWithExtension(file, extension);
    }

    private static void findFilesWithExtension(File directory, String extension) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}
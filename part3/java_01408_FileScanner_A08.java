import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_01408_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return !pathname.isHidden() && pathname.getName().endsWith(extension) && !pathname.canRead();
                }
            });

            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                }
            } else {
                System.out.println("No files with the specified extension in the directory.");
            }
        } else {
            System.out.println("Invalid directory or it's not a directory.");
        }
    }
}
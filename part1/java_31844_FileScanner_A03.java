import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_31844_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String extension = "txt";

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(extension);
                }
            });

            if (files != null) {
                Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }
}
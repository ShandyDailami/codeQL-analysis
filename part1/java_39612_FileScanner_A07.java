import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_39612_FileScanner_A07 {

    public static void main(String[] args) {
        File f = new File(".");

        // Using a FileFilter.
        System.out.println("Files in directory " + f.getAbsolutePath());
        for (File file : f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        })) {
            System.out.println(file.getName());
        }

        // Using a FilenameFilter.
        System.out.println("Files in directory " + f.getAbsolutePath());
        for (File file : f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(".*\\.txt$", name);
            }
        })) {
            System.out.println(file.getName());
        }
    }
}
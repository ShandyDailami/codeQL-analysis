import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_33979_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File(".");

        // Using FileFilter
        File[] textFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        // Using anonymous inner class
        File[] textFiles2 = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        // Using lambda expression
        File[] textFiles3 = file.listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(".txt"));

        // Printing the file names
        Arrays.stream(textFiles).forEach(System.out::println);
        Arrays.stream(textFiles2).forEach(System.out::println);
        Arrays.stream(textFiles3).forEach(System.out::println);
    }
}
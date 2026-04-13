import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_03702_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");

        // Using File's list method
        String[] unsafeFiles = file.list((File dir, String name) -> name.endsWith(".unsafe"));
        Arrays.stream(unsafeFiles).forEach(System.out::println);

        // Using File's listFiles method with FileFilter
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".unsafe");
            }
        };
        Arrays.stream(file.listFiles(filter)).forEach(System.out::println);

        // Using File's listFiles method with FilenameFilter
        FilenameFilter filter2 = (dir, name) -> name.endsWith(".unsafe");
        Arrays.stream(file.listFiles(filter2)).forEach(System.out::println);
    }
}
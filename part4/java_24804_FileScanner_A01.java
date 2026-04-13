import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_24804_FileScanner_A01 {

    private static class EndingInA implements FileFilter {
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith("a");
        }
    }

    public static void main(String[] args) {
        File directory = new File(".");

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        File[] endingInAFiles = directory.listFiles(new EndingInA());

        System.out.println("Hidden files: " + Arrays.toString(hiddenFiles));
        System.out.println("Files ending in 'a': " + Arrays.toString(endingInAFiles));
    }
}
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_33476_FileScanner_A07 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        scanFiles(rootDirectory, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        });
    }

    private static void scanFiles(File rootDirectory, FileFilter fileFilter) {
        File[] files = rootDirectory.listFiles(fileFilter);
        if (files != null) {
            Arrays.stream(files).forEach(AuthFailureScanner::checkFile);
        }
    }

    private static void checkFile(File file) {
        // Implementation here, for example, reading a file and checking for a certain string
        // For the purpose of this example, we'll just print a message
        System.out.println("Checking file: " + file.getAbsolutePath());
    }
}
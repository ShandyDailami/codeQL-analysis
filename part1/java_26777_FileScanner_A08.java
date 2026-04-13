import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_26777_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            Arrays.sort(hiddenFiles, (file1, file2) -> file1.compareTo(file2));

            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isFile()) {
                    System.out.println("Hidden file: " + hiddenFile.getName());
                }
            }
        } else {
            System.out.println("No hidden files found.");
        }
    }
}
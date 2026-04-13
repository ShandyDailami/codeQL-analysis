import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_27481_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        findTextFiles(directory);
    }

    private static void findTextFiles(File directory) {
        FileFilter textFilesFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };
        File[] textFiles = directory.listFiles(textFilesFilter);
        if (textFiles != null) {
            Arrays.stream(textFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
        }
    }
}
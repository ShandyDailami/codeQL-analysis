import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_04104_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(filter);
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files in directory or path was invalid");
        }
    }
}
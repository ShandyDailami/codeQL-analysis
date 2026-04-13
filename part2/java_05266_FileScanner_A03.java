import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_05266_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Specify the directory path
        String extension = ".txt"; // Specify the file extension
        
        File directory = new File(directoryPath);
        
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        };
        
        File[] files = directory.listFiles(filter);
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        }
    }
}
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_11624_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".exe")) {
                    return false;
                }

                // Injecting code here. For simplicity, we'll just print the file name.
                System.out.println("File: " + pathname.getName());

                // Return true if the file should be accepted.
                return true;
            }
        };

        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getPath()));
        } else {
            System.out.println("No files found!");
        }
    }
}
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_41535_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".txt");
                }
            });
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    // do something with file (e.g., print its name)
                    System.out.println(file.getName());
                });
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}
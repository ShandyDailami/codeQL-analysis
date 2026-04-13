import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_03942_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Here, you can add your security-sensitive operations
                // For example, we'll only accept '.txt' files
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File[] hiddenFiles = directory.listFiles(filter);
        if (hiddenFiles != null) {
            Arrays.stream(hiddenFiles)
                    .map(File::getName)
                    .forEach(System.out::println);
        } else {
            System.out.println("No hidden files found");
        }
    }
}
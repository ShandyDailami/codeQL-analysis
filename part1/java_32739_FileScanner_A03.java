import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_32739_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            Arrays.stream(hiddenFiles).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No hidden files found in the directory.");
        }
    }
}
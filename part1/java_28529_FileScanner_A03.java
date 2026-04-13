import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_28529_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // provide your directory path
        String[] extensionsToFilter = { ".txt", ".exe", ".dll" }; // provide the extensions you want to filter

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String ext : extensionsToFilter) {
                    if (name.endsWith(ext)) {
                        return false;
                    }
                }
                return true;
            }
        };

        File[] files = directory.listFiles(filter);

        if (files != null) {
            Arrays.sort(files); // sort files by name

            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}
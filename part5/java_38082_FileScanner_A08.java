import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_38082_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        fileScanner(dirPath);
    }

    private static void fileScanner(String dirPath) {
        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Cannot read directory");
            return;
        }

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true; // accept all files
            }
        };

        File[] listFiles = directory.listFiles(filter);
        if (listFiles == null) {
            return;
        }

        Arrays.sort(listFiles);

        for (File file : listFiles) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
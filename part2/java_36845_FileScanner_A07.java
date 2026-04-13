import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class java_36845_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        String directory = "/path/to/directory";  // replace with your directory

        File dir = new File(directory);

        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true;  // accept all files
            }
        });

        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
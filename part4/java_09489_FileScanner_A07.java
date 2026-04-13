import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_09489_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/your/directory"; // Replace with your directory path

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("AuthFailure");
            }
        };

        printFiles(directory, filter);
    }

    public static void printFiles(File dir, FilenameFilter filter) throws IOException {
        for (File file : dir.listFiles(filter)) {
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                printFiles(file, filter);
            }
        }
    }
}
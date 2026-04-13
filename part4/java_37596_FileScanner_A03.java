import java.io.File;
import java.io.FilenameFilter;

public class java_37596_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory path

        File dir = new File(directory);

        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");

        findFiles(dir, filter);
    }

    private static void findFiles(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    findFiles(file, filter);
                }
            }
        }
    }
}
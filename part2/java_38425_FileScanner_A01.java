import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_38425_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = ".*.txt"; // replace with your extension

        File startingDirectory = new File(directory);

        File[] securityFiles = startingDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt") && pathname.getAbsolutePath().contains("security sensitive operations");
            }
        });

        for (File file : securityFiles) {
            System.out.println("Security sensitive file: " + file.getAbsolutePath());
        }
    }
}
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_39799_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory

        File dir = new File(directory);

        File[] matchingFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equals("target");
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println("Match found: " + file.getPath());
            }
        } else {
            System.out.println("No files found in directory");
        }
    }
}
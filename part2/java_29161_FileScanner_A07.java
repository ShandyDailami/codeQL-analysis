import java.io.File;
import java.io.FilenameFilter;

public class java_29161_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String[] extensions = {".jpg", ".png", ".gif"}; // replace with your extensions

        File directoryFile = new File(directory);
        String[] files = directoryFile.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String ext : extensions) {
                    if (name.toLowerCase().endsWith(ext)) {
                        return true;
                    }
                }
                return false;
            }
        });

        for (String file : files) {
            System.out.println(file);
        }
    }
}
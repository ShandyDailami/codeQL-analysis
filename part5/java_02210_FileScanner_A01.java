import java.io.File;
import java.io.FilenameFilter;

public class java_02210_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = System.getProperty("user.dir");
        System.out.println("Scanning directory: " + directory);

        File filesDir = new File(directory);
        File[] listOfFiles = filesDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.canRead() && !file.isHidden();
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getPath());
            }
        }
    }
}
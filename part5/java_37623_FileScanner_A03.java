import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_37623_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "."; // change this to the directory you want to scan
        String extension = ".txt";

        File dir = new File(directory);

        File[] txtFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No text files found in directory.");
        }
    }
}
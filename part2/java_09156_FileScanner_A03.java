import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_09156_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "./";  // Change to your directory
        String extension = ".txt";  // Change to your extension

        File dir = new File(directory);

        File[] matchingFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with extension " + extension + " found in " + dir.getAbsolutePath());
        }
    }
}
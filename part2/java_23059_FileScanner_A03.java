import java.io.File;
import java.io.FileFilter;

public class java_23059_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
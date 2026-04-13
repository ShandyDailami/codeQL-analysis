import java.io.File;
import java.io.FileFilter;

public class java_23212_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File dir = new File(directoryPath);

        // create a FileFilter that filters out hidden files
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        };

        // use File.listFiles method to get an array of File objects for the directory
        File[] hiddenFiles = dir.listFiles(filter);

        // print out the names of the hidden files
        for (File file : hiddenFiles) {
            System.out.println(file.getName());
        }
    }
}
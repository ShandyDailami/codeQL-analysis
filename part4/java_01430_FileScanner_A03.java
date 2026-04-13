import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_01430_FileScanner_A03 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");
        String[] extensions = {".txt", ".exe"};

        // Using a FileFilter to filter files by extension
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Returns true if the file ends with one of the specified extensions
                return Arrays.asList(extensions).contains(pathname.getName().toLowerCase().substring(pathname.getName().lastIndexOf(".")));
            }
        };

        // Using a FilenameFilter to filter files by name
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // Returns true if the file name is "rootDirectory"
                return name.equals(rootDirectory.getName());
            }
        };

        // Using recursive method to list all files in the root directory
        File[] files = rootDirectory.listFiles(filter);
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else {
                File[] nestedFiles = file.listFiles(filter);
                for (File nestedFile : nestedFiles) {
                    if (nestedFile.isFile()) {
                        System.out.println("  " + nestedFile.getName());
                    }
                }
            }
        }
    }
}
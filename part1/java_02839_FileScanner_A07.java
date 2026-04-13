import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_02839_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return !pathname.isHidden();
            }
        });

        for (File file : hiddenFiles) {
            if (file.isFile()) {
                try {
                    if (file.canRead()) {
                        // read file here
                        System.out.println("Reading file: " + file.getAbsolutePath());
                    } else {
                        System.out.println("File is not readable: " + file.getAbsolutePath());
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.getAbsolutePath());
                }
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
            }
        }
    }
}
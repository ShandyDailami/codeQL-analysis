import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class java_39376_FileScanner_A03 {

    private static final String PATH = "path_to_directory"; // replace with your directory

    public static void main(String[] args) {
        File directory = new File(PATH);

        // create a file filter to only accept directory
        FileFilter fileFilter = (dir, name) -> dir.isDirectory();

        scanDirectory(directory, fileFilter);
    }

    private static void scanDirectory(File directory, FileFilter fileFilter) {
        File[] files = directory.listFiles(fileFilter);

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file, fileFilter);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
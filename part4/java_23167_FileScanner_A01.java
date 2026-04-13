import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_23167_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt";

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No text files found in directory.");
        }
    }
}
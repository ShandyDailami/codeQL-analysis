import java.io.File;
import java.io.FilenameFilter;

public class java_09905_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        } else {
            System.out.println("No files with extension " + extension + " found in " + directoryPath);
        }
    }
}
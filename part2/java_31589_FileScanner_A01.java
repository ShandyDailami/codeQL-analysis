import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_31589_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        findTxtFiles(directoryPath);
    }

    private static void findTxtFiles(String directoryPath) {
        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        for (File txtFile : txtFiles) {
            System.out.println("Found .txt file: " + txtFile.getAbsolutePath());
        }
    }
}
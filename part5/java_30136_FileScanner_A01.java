import java.io.File;
import java.io.FileFilter;

public class java_30136_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Specify your directory here

        File dir = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // This filter will only accept .txt files
                return pathname.getName().endsWith(".txt");
            }
        };

        scanDirectory(dir, fileFilter);
    }

    private static void scanDirectory(File dir, FileFilter fileFilter) {
        File[] listFiles = dir.listFiles(fileFilter);

        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    // This is a text file, print its name
                    System.out.println("Text file: " + file.getName());
                } else if (file.isDirectory()) {
                    // This is a directory, recurse
                    scanDirectory(file, fileFilter);
                }
            }
        }
    }
}
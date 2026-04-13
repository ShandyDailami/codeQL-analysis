import java.io.File;
import java.io.FilenameFilter;

public class java_33574_FileScanner_A01 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory";  // replace with your directory path
        File directory = new File(dirPath);

        // This function will be used to filter out .txt files
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");  // replace with the extension of your files
            }
        };

        scanDirectory(directory, filter);
    }

    private static void scanDirectory(File directory, FilenameFilter filter) {
        File[] listOfFiles = directory.listFiles(filter);

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // You can add code here to process the file, such as reading, writing, or deleting it
                    System.out.println("Processing file: " + file.getName());
                } else if (file.isDirectory()) {
                    // Recursive call
                    scanDirectory(file, filter);
                }
            }
        }
    }
}
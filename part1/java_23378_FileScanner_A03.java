import java.io.File;
import java.io.FileFilter;

public class java_23378_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String searchPattern = "*.txt"; // Replace with your search pattern

        File startingDirectory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(searchPattern);
            }
        };

        printFilesInDirectory(startingDirectory, fileFilter);
    }

    private static void printFilesInDirectory(File directory, FileFilter fileFilter) {
        File[] matchingFiles = directory.listFiles(fileFilter);

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file, fileFilter);
                }
            }
        }
    }
}
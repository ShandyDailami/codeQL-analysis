import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_27828_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileName = "targetFile.txt"; // replace with the file you want to search for

        fileSearch(new File(directoryPath), fileName);
    }

    private static void fileSearch(File directory, String fileName) {
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equalsIgnoreCase(fileName);
            }
        });

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                fileSearch(file, fileName);
            }
        }
    }
}
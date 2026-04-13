import java.io.File;
import java.io.FileFilter;

public class java_37974_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        String fileNameToMatch = "file.txt";

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().equals(fileNameToMatch);
            }
        };

        File[] matchingFiles = directory.listFiles(fileFilter);

        if (matchingFiles != null && matchingFiles.length > 0) {
            System.out.println("Matching file: " + matchingFiles[0].getAbsolutePath());
        } else {
            System.out.println("No matching file found.");
        }
    }

}
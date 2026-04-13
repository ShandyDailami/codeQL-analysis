import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_26830_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Directory does not have read permissions");
            return;
        }

        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            Arrays.sort(listOfFiles); // sort files by name
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory(file.getAbsolutePath());
                }
            }
        }
    }
}
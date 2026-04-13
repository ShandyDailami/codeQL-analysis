import java.io.File;
import java.util.regex.Pattern;

public class java_36504_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        searchFiles(directory, fileExtension);
    }

    private static void searchFiles(File directory, String fileExtension) {
        File[] result = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
        if (result != null) {
            for (File file : result) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    searchFiles(file, fileExtension);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
        System.out.println("Last modified: " + file.lastModified());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("------------------------");
    }
}
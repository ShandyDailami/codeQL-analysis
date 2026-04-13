import java.io.File;
import java.util.Arrays;
import java.util.List;

public class java_39528_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("path_to_your_directory");
        List<String> extensionsToIgnore = Arrays.asList("exe", "dll", "pdf"); // List of extensions to ignore

        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && !extensionsToIgnore.contains(getFileExtension(file.getPath()))) {
                    System.out.println(file.getName());
                }
            }
        }
    }

    private static String getFileExtension(String filename) {
        String extension = "";
        int i = filename.lastIndexOf('.');
        if (i > 0) {
            extension = filename.substring(i + 1);
        }
        return extension;
    }
}
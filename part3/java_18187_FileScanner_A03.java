import java.io.File;
import java.io.FilenameFilter;

public class java_18187_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "C:\\your\\directory\\path";
        String extension = "txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("." + extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the extension: " + extension);
        }
    }
}
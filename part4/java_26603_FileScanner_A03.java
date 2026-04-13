import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_26603_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "./src";
        String fileType = ".*\\.txt$";

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && Pattern.matches(fileType, file.getName());
            }
        };

        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                System.out.println("File found: " + file.getPath());
            }
        }
    }
}
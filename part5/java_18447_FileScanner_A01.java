import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_18447_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] extensions = { ".txt" };
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                for (String extension : extensions) {
                    if (pathname.getName().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };
        File[] textFiles = directory.listFiles(fileFilter);
        if (textFiles != null) {
            Arrays.sort(textFiles, String.CASE_INSENSITIVE_ORDER);
            for (File textFile : textFiles) {
                System.out.println(textFile.getName());
            }
        }
    }
}
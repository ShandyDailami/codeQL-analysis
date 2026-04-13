import java.io.File;
import java.util.regex.Pattern;

public class java_11610_FileScanner_A03 {

    public static void main(String[] args) {
        String dirPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(dirPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead() && !file.isHidden() && Pattern.matches(".*\\.(txt|docx|pdf)$", file.getName())) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
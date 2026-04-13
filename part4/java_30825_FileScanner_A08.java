import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_30825_FileScanner_A08 {

    public static void main(String[] args) {
        File root = new File(".");
        String[] files = root.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return !name.startsWith(".") && Pattern.matches("^.*\\.java$", name);
            }
        });
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
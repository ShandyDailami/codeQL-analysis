import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_09221_FileScanner_A07 {
    public static void main(String[] args) {
        File root = new File(".");

        String[] extensions = { ".txt", ".jpg", ".png", ".jpeg", ".gif" };
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if (name.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };

        File[] files = root.listFiles(filter);
        if (files != null) {
            Arrays.sort(files); // sorts the files by name
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        }
    }
}
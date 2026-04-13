import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_26287_FileScanner_A08 {
    private static final List<String> EXCLUDED_EXTENSIONS = new ArrayList<>();
    private static final String[] INCLUDED_EXTENSIONS = {".txt", ".java"};

    static {
        EXCLUDED_EXTENSIONS.add(".git");
        EXCLUDED_EXTENSIONS.add(".idea");
        EXCLUDED_EXTENSIONS.add(".db");
        EXCLUDED_EXTENSIONS.add(".xml");
        EXCLUDED_EXTENSIONS.add(".log");
    }

    public static void main(String[] args) {
        File root = new File(".");
        scan(root);
    }

    private static void scan(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    scan(f);
                }
            }
        } else {
            if (isFileAccepted(file) && !isFileExcluded(file)) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    private static boolean isFileExcluded(File file) {
        for (String excluded : EXCLUDED_EXTENSIONS) {
            if (file.getName().toLowerCase().endsWith(excluded)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFileAccepted(File file) {
        String name = file.getName().toLowerCase();
        for (String included : INCLUDED_EXTENSIONS) {
            if (name.endsWith(included)) {
                return true;
            }
        }
        return false;
    }
}
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_01029_FileScanner_A03 {
    public static void main(String[] args) {
        File root = new File(".");
        printFiles(root, 0);
    }

    private static void printFiles(File dir, int depth) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches("^[a-zA-Z0-9]+([_-]*[a-zA-Z0-9]+)*$");
            }
        });
        if (files != null) {
            for (File file : files) {
                for (int i = 0; i < depth; i++) {
                    System.out.print("--");
                }
                System.out.println(file.getAbsolutePath());
            }
        }
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                printFiles(file, depth + 1);
            }
        }
    }
}
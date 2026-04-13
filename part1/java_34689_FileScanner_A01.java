import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_34689_FileScanner_A01 {
    public static void main(String[] args) {
        File root = new File(".");
        scanDir(root, "");
    }

    private static void scanDir(File dir, String indent) {
        File[] list = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });
        if (list == null) {
            list = new File[0];
        }
        for (File file : list) {
            System.out.println(indent + file.getName());
            if (file.isDirectory()) {
                scanDir(file, indent + "  ");
            }
        }
    }
}
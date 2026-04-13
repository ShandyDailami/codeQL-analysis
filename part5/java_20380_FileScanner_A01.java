import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_20380_FileScanner_A01 {
    public static void main(String[] args) {
        File root = new File(".");
        String[] extensions = {".txt", ".exe", ".jpg", ".png"};
        findFiles(root, extensions);
    }

    public static void findFiles(File root, String[] extensions) {
        File[] list = root.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String ext : extensions) {
                    if (name.toLowerCase().endsWith(ext)) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    findFiles(file, extensions);
                }
            }
        }
    }
}
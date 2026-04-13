import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_16535_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] extensions = {".java"};

        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return Arrays.asList(extensions).contains(pathname.getName().toLowerCase().substring(pathname.getName().lastIndexOf(".")));
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No java files in directory");
        }
    }
}
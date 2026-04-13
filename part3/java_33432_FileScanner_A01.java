import java.io.File;
import java.io.FileFilter;

public class java_33432_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File("path/to/directory");
        listFiles(directory);
    }

    public static void listFiles(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
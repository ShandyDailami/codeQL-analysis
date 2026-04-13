import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_38003_FileScanner_A03 {

    public static void main(String[] args) {
        File root = new File(".");
        String ext = "java";

        File[] javaFiles = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(ext);
            }
        });

        for (File file : javaFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
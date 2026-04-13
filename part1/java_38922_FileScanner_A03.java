import java.io.File;
import java.io.FileFilter;

public class java_38922_FileScanner_A03 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");
        findJavaFiles(rootDirectory);
    }

    public static void findJavaFiles(File root) {
        FileFilter javaFileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File[] files = root.listFiles(javaFileFilter);

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
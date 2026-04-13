import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_35796_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");

        // Using a FileFilter to find .java files
        File[] javaFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        });

        // Using a FilenameFilter to find .java files
        File[] otherFiles = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        for (File file : javaFiles) {
            System.out.println(file.getAbsolutePath());
        }

        for (File file : otherFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
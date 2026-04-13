import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_30154_FileScanner_A03 {

    public static void main(String[] args) {
        File root = new File(".");
        String ext = "java";

        File[] hiddenFiles = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        File[] javaFiles = root.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }
        });

        System.out.println("Hidden files: ");
        for (File file : hiddenFiles) {
            System.out.println(file.getName());
        }

        System.out.println("\nFiles with .java extension: ");
        for (File file : javaFiles) {
            System.out.println(file.getName());
        }
    }
}
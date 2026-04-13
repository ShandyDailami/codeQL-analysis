import java.io.File;
import java.io.FilenameFilter;

public class java_07467_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] extensions = {"txt", "doc", "pdf"};
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if (name.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
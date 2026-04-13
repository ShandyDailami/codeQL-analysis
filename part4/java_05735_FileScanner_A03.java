import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_05735_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File(".");
        String[] extensions = {"txt", "pdf", "docx", "png", "jpg"};

        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                for (String extension : extensions) {
                    if (pathname.getName().toLowerCase().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (files != null) {
            for (File f : files) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
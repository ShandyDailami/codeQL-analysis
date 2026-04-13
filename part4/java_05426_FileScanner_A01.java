import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_05426_FileScanner_A01 {
    public static void main(String[] args) {
        File root = new File(".");
        String[] extensions = {".txt", ".pdf"};

        File[] list = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return Arrays.asList(extensions).contains(pathname.getName().toLowerCase().substring(pathname.getName().lastIndexOf(".")));
            }
        });

        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}
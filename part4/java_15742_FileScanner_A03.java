import java.io.File;
import java.io.FilenameFilter;

public class java_15742_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] extensions = {"txt", "pdf", "docx", "xlsx"};
        fileScan(dir, extensions);
    }

    public static void fileScan(File dir, String[] extensions) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                for (String ext : extensions) {
                    if (pathname.getName().toLowerCase().endsWith(ext)) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileScan(file, extensions);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
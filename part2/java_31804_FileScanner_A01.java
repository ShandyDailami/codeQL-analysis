import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_31804_FileScanner_A01 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] extensions = {"txt", "pdf"}; // Specify the file extensions you want to search for
        findFiles(dir, extensions);
    }

    public static void findFiles(File dir, String[] extensions) {
        File[] listOfFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                for (String extension : extensions) {
                    if (pathname.getName().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    findFiles(file, extensions);
                }
            }
        }
    }
}
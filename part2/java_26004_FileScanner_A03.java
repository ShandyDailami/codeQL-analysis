import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26004_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");

        String[] safeExtensions = {"txt", "exe", "jar", "dll", "pdf", "docx", "pptx", "png", "jpg", "jpeg"};

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                for (String ext : safeExtensions) {
                    if (pathname.getName().toLowerCase().endsWith(ext)) {
                        return true;
                    }
                }
                return false;
            }
        };

        try {
            FileScanner scanner = new FileScanner(directory, filter);
            scanner.scan();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileScanner {
    private File directory;
    private FileFilter filter;

    public java_26004_FileScanner_A03(File directory, FileFilter filter) {
        this.directory = directory;
        this.filter = filter;
    }

    public void scan() throws FileNotFoundException {
        File[] foundFiles = directory.listFiles(filter);

        if (foundFiles != null) {
            for (File file : foundFiles) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
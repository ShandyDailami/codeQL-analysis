import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19249_FileScanner_A08 {

    public static void main(String[] args) {

        FileScanner scanner = new FileScanner(new File("."), new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.getName().startsWith(".");
            }
        });

        try {
            scanner.scan();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileScanner {

    private File[] files;
    private FileFilter filter;

    public java_19249_FileScanner_A08(File directory, FileFilter filter) {
        this.filter = filter;
        this.files = directory.listFiles(this.filter);
    }

    public void scan() throws FileNotFoundException {
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println(file.getAbsolutePath() + "/");
                    scan(file);
                }
            }
        }
    }
}
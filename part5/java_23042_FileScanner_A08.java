import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_23042_FileScanner_A08 {

    private File file;

    public java_23042_FileScanner_A08(String path) {
        file = new File(path);
    }

    public void searchFile(String name) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().equals(name);
            }
        });
        if(files != null) {
            for(File f : files) {
                System.out.println("Found file: " + f.getAbsolutePath());
            }
        } else {
            System.out.println("File not found: " + name);
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner(".");
        scanner.searchFile("A08_IntegrityFailure.txt");
    }

}
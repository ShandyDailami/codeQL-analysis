import java.io.File;
import java.io.FilenameFilter;

public class java_23858_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] files = directory.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true; // Accept all files
            }
        });

        for (String file : files) {
            File fileObject = new File(file);
            System.out.println(fileObject.getName());
        }
    }
}
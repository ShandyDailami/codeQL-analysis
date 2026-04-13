import java.io.File;
import java.io.FilenameFilter;

public class java_09433_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        String[] files = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
        });

        for (String file : files) {
            File fileObj = new File(file);
            if (fileObj.isFile()) {
                System.out.println(fileObj.getName());
            }
        }
    }
}
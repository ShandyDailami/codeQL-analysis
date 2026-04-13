import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_17382_FileScanner_A07 {

    public static void main(String[] args) {
        File rootDir = new File(".");
        String[] files = rootDir.list();

        if (files != null) {
            for (String file : files) {
                File fileObj = new File(file);
                if (fileObj.isFile() && fileObj.canRead()) {
                    System.out.println(file);
                }
            }
        }
    }

}
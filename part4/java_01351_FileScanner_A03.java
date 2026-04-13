import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_01351_FileScanner_A03 {

    public static void main(String[] args) {
        File dir = new File("TestDir");

        if (dir.exists() && dir.isDirectory()) {
            String[] list = dir.list();

            if (list != null) {
                for (String filename : list) {
                    File file = new File(dir, filename);
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }
    }
}
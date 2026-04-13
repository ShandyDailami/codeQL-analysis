import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_40303_FileScanner_A08 {

    public static void main(String[] args) {

        File file = new File(".");

        // Using the File class to list all files in the current directory.
        String[] list = file.list();
        if(list != null) {
            Arrays.sort(list);
            for(String name : list) {
                File f = new File(file, name);

                // Using the File class to filter files based on extension.
                if(f.isFile() && f.getName().matches(".*\\.java$")) {
                    System.out.println(f);
                }
            }
        }
    }
}
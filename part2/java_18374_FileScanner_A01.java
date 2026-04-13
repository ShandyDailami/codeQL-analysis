import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_18374_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");
        String[] txtFiles = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(".*\\.txt$", name);
            }
        });

        if(txtFiles != null) {
            for(String txtFile : txtFiles) {
                System.out.println(txtFile);
            }
        } else {
            System.out.println("No .txt files found in the current directory and all subdirectories.");
        }
    }
}
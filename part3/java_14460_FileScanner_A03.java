import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_14460_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] extensions = {".txt"};
        File[] txtFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith("txt");
            }
        });
        if(txtFiles != null) {
            for(File file : txtFiles) {
                System.out.println(file.getPath());
            }
        }
    }
}
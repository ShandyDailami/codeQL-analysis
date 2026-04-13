import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_37486_FileScanner_A01 {

    public static void main(String[] args) {
        File root = new File(".");
        String[] extensions = {".txt"};
        File[] hiddenFiles = root.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return Arrays.asList(extensions).contains(pathname.getName().toLowerCase().substring(pathname.getName().lastIndexOf(".")));
            }
        });
        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No files ending with .txt in the current directory or its subdirectories.");
        }
    }
}
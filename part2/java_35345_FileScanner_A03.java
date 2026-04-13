import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

public class java_35345_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File dir = new File(".");
        File[] hiddenFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        for (File file : Arrays.asList(hiddenFiles).subList(0, 5)) {  // limit to first 5 hidden files
            if (file.isFile() && file.getName().endsWith(".jpg")) {
                System.out.println("Found jpg file: " + file.getName());
            }
        }
    }
}
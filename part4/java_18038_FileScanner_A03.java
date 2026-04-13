import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Set;

public class java_18038_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File(".");
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return false;
            }
        };

        Set<File> injectionFiles = new HashSet<>();
        file.getParentFile().listFiles(filter).forEach(file1 -> {
            if(file1.getName().endsWith(".java")) {
                injectionFiles.add(file1);
            }
        });

        for (File file1 : injectionFiles) {
            System.out.println("File contains injection: " + file1.getPath());
        }
    }
}
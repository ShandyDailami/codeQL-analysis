import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_35818_FileScanner_A01 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        scanDirectory(rootDirectory, new FileFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && file.canRead() && !file.getName().endsWith(".java");
            }
        });
    }

    public static void scanDirectory(File dir, FilenameFilter filter) {
        File[] listFiles = dir.listFiles(filter);
        if (listFiles == null) {
            return;
        }

        Arrays.stream(listFiles).forEach(file -> {
            if (file.isDirectory()) {
                scanDirectory(file, filter);
            } else {
                System.out.println("Found a source file: " + file.getPath());
            }
        });
    }
}
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_03653_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");
        scanDirectory(rootDirectory, "");
    }

    private static void scanDirectory(File directory, String indent) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(indent + file.getName());
            }
        }

        File[] directories = directory.listFiles(File::isDirectory);
        if (directories != null) {
            for (File dir : directories) {
                scanDirectory(dir, indent + "  ");
            }
        }
    }
}
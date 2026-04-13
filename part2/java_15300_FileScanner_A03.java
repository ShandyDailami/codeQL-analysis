import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_15300_FileScanner_A03 {

    public static void main(String[] args) {
        File rootDirectory = new File("C:\\path\\to\\directory");
        listFilesRecursively(rootDirectory);
    }

    private static void listFilesRecursively(File rootDirectory) {
        File[] files = rootDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && !pathname.getName().endsWith(".java");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }

        File[] directories = rootDirectory.listFiles(File::isDirectory);
        if (directories != null) {
            for (File directory : directories) {
                listFilesRecursively(directory);
            }
        }
    }
}
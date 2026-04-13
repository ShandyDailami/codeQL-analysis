import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_04413_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        File rootDirectory = new File(".");
        printDirectories(rootDirectory, "");
    }

    private static void printDirectories(File directory, String indent) throws IOException {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                return false;
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(indent + file.getName());
                printDirectories(file, indent + "  ");
            }
        }
    }
}
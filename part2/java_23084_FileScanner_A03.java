import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_23084_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        File rootDir = new File(".");
        String[] files = rootDir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isDirectory();
            }
        });
        for (String fileName : files) {
            printDirectoryContents(new File(fileName));
        }
    }

    private static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in " + dir);
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Dir: " + file.getName());
                printDirectoryContents(file);
            }
        }
    }
}
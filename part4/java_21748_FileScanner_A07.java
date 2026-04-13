import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_21748_FileScanner_A07 implements FileFilter {

    private String[] extensions = {"txt", "jpg", "png", "docx"}; // list of file extensions

    public java_21748_FileScanner_A07() {
    }

    public void listFiles(String directory) {
        File root = new File(directory);

        listFilesRecursive(root);
    }

    private void listFilesRecursive(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(extensions[0])) {
                        System.out.println(file.getName());
                    }
                } else if (file.isDirectory()) {
                    listFilesRecursive(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.listFiles(".");
    }
}
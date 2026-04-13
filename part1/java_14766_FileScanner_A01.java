import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_14766_FileScanner_A01 {

    private File rootDirectory;

    public java_14766_FileScanner_A01(String rootDirectoryPath) {
        this.rootDirectory = new File(rootDirectoryPath);
    }

    public void scanDirectory(String extension) {
        File[] files = this.rootDirectory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(extension.toLowerCase());
            }
        });

        if(files != null) {
            Arrays.sort(files);

            for(File file : files) {
                if(file.isDirectory()) {
                    scanDirectory(file.getName());
                } else {
                    // Do something with the file
                    System.out.println("Found file: " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        scanner.scanDirectory(".txt");
    }
}
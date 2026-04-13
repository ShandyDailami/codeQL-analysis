import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class java_25945_FileScanner_A07 {
    private Set<String> extensions = new HashSet<String>();

    public java_25945_FileScanner_A07() {
        // Add extensions you want to scan here
        extensions.add(".txt");
        extensions.add(".jpg");
    }

    public Set<String> getExtensions() {
        return extensions;
    }

    public void setExtensions(Set<String> extensions) {
        this.extensions = extensions;
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile() && getExtensions().contains(getFileExtension(file.getName()))) {
                    System.out.println("Found file: " + file.getName());
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }

    private String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        }
        return filename.substring(lastDotIndex + 1);
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory("C:\\path\\to\\your\\directory");
    }
}
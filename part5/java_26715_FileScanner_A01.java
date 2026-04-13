import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_26715_FileScanner_A01 implements FilenameFilter {

    private final String directoryPath;

    public java_26715_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }

    public static void main(String[] args) {
        TextFileFinder finder = new TextFileFinder("/path/to/directory");
        File[] textFiles = new File(finder.directoryPath).listFiles(finder);

        if (textFiles != null) {
            for (File file : textFiles) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No text files found in the directory!");
        }
    }
}
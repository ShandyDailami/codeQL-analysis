import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class java_03851_FileScanner_A01 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String extension = "txt";

        FileScanner fileScanner = new FileScanner(directory, extension);
        List<File> fileList = fileScanner.scan();

        fileList.forEach(file -> System.out.println(file.getName()));
    }

}

class FileScanner {
    private final File directory;
    private final String extension;

    public java_03851_FileScanner_A01(String directory, String extension) {
        this.directory = new File(directory);
        this.extension = extension;
    }

    public List<File> scan() {
        return Arrays.asList(this.directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        }));
    }
}
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class java_09186_FileScanner_A03 {

    private static final String SPECIFIED_EXTENSION = ".txt";

    private static List<String> fileList;

    public static void main(String[] args) {
        // specify the directory to be scanned
        String rootDir = "/path/to/your/directory";

        fileList = Arrays.asList(getFiles(new File(rootDir)));

        // print the list of files
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }

    private static String[] getFiles(File directory) {
        return directory.list(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(SPECIFIED_EXTENSION);
            }
        });
    }
}
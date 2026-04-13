import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_04623_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String extension = "txt";

        File dir = new File(directory);

        File[] result = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        Arrays.stream(result).forEach(File::getName);
    }
}
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_00779_FileScanner_A03 {

    public static void main(String[] args) {
        String rootDirectory = "/path/to/directory";  // Specify your directory here
        String targetExtension = ".exe";  // Specify the target file extension here

        File root = new File(rootDirectory);

        File[] result = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(targetExtension);
            }
        });

        if (result != null) {
            Arrays.sort(result);
            for (File file : result) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
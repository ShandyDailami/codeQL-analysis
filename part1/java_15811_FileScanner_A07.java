import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_15811_FileScanner_A07 {

    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("A07_AuthFailure.java");

    public static void main(String[] args) {
        scanDirectory(".");
    }

    private static void scanDirectory(String directory) {
        File rootDirectory = new File(directory);
        File[] files = rootDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return FILE_NAME_PATTERN.matcher(name).matches();
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                } else {
                    System.out.println(file.getPath());
                }
            }
        }
    }
}
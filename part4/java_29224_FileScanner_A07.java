import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_29224_FileScanner_A07 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] secureFiles = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && !file.getName().startsWith(".") && !file.canRead();
            }
        });

        Arrays.stream(secureFiles).forEach(System.out::println);
    }
}
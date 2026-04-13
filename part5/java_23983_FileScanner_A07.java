import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_23983_FileScanner_A07 {

    public static void main(String[] args) {

        File directory = new File(".");
        String[] files = directory.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        Arrays.sort(files);

        for (String name : files) {
            File file = new File(name);
            long length = file.length();

            if (length > 500) {
                System.out.println(file.getAbsolutePath() + " " + length);
            }
        }
    }
}
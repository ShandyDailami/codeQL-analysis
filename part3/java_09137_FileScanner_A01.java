import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_09137_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        File dir = new File(".");
        String[] files = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                // Returns true if the file should be included in the list.
                return name.endsWith(".java");
            }
        });

        for (String file : files) {
            System.out.println(file);
        }
    }
}
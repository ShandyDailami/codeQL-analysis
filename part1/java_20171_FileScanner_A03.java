import java.io.File;
import java.io.FilenameFilter;

public class java_20171_FileScanner_A03 {
    public static void main(String[] args) {
        String rootDirectory = "/path/to/directory";
        String searchTerm = "searchTerm";

        File root = new File(rootDirectory);

        File[] results = root.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(searchTerm);
            }
        });

        if (results != null) {
            for (File file : results) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the extension " + searchTerm);
        }
    }
}
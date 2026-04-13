import java.io.File;
import java.io.FilenameFilter;

public class java_20908_FileScanner_A03 {
    public static void main(String[] args) {
        File rootDir = new File("."); // the current directory

        String[] extensions = {"txt", "pdf", "docx", "xlsx", "json"};

        // create a FilenameFilter that only accepts files with the extensions we're interested in
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if (name.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };

        // use the File class to list all files in the current directory
        File[] files = rootDir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                // print out the file name
                System.out.println(file.getName());
            }
        }
    }
}
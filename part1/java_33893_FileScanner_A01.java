import java.io.File;
import java.io.FilenameFilter;

public class java_33893_FileScanner_A01 {

    public static void main(String[] args) {
        File startingDirectory = new File("."); // current directory

        String[] files = startingDirectory.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // only txt files
            }
        });

        for (String fileName : files) {
            File file = new File(startingDirectory, fileName);

            // Print out the file path
            System.out.println("File path: " + file.getPath());
        }
    }
}
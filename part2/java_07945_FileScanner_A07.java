import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_07945_FileScanner_A07 {
    public static void main(String[] args) {
        String dir = "/path/to/directory"; // replace with your directory
        String extension = "txt"; // replace with your extension

        File startingDirectory = new File(dir);

        File[] filesWithExtension = startingDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        for(File file : filesWithExtension) {
            System.out.println(file.getName());
        }
    }
}
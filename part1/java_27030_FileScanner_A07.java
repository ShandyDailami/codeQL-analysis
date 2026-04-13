import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_27030_FileScanner_A07 {
    private static final String TXT_EXTENSION = ".txt";

    public static void main(String[] args) {
        File rootDirectory = new File(".");

        // Using FileFilter to filter files based on extension
        FileFilter txtFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(TXT_EXTENSION);
            }
        };

        File[] txtFiles = rootDirectory.listFiles(txtFilter);

        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getAbsolutePath()));
        } else {
            System.out.println("No .txt files found in the current directory.");
        }
    }
}
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_21627_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("."); // get current directory
        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            Arrays.sort(hiddenFiles, String.CASE_INSENSITIVE_ORDER);
            for (File file : hiddenFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No hidden files in directory.");
        }
    }
}
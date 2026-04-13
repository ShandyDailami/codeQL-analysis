import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class java_35609_FileScanner_A07 {
    private static final String SPECIFIC_EXTENSION = ".txt";

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        String[] extensions = { SPECIFIC_EXTENSION };
        File[] hiddenFiles = rootDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            Arrays.sort(hiddenFiles, String.CASE_INSENSITIVE_ORDER);
            List<File> fileList = Arrays.asList(hiddenFiles);

            for (File file : fileList) {
                if (file.isFile() && file.getName().endsWith(SPECIFIC_EXTENSION)) {
                    System.out.println("Hidden file found: " + file.getAbsolutePath());
                }
            }
        }
    }
}
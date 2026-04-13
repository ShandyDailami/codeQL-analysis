import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_29263_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "."; // replace with your directory
        List<String> txtFiles = findTxtFiles(directory);

        for (String file : txtFiles) {
            System.out.println("TXT file found: " + file);
        }
    }

    private static List<String> findTxtFiles(String directory) {
        List<String> txtFiles = new ArrayList<>();

        File file = new File(directory);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });

        for (File f : files) {
            txtFiles.add(f.getAbsolutePath());
        }

        return txtFiles;
    }
}
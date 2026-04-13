import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_09535_FileScanner_A03 {

    public static void main(String[] args) {
        File rootDir = new File(".");
        Set<String> extensions = new HashSet<>(Arrays.asList("txt"));
        int maxSize = 10240; // 10KB in bytes

        File[] matchedFiles = rootDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return extensions.contains(getFileExtension(pathname))
                        && pathname.length() < maxSize;
            }
        });

        if (matchedFiles != null) {
            for (File file : matchedFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the specified criteria.");
        }
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        int i = name.lastIndexOf('.');
        return i == -1 ? "" : name.substring(i + 1);
    }
}
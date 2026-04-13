import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_29406_FileScanner_A08 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        Set<String> extensions = new HashSet<>(Arrays.asList("jpg", "png", "gif"));

        File dir = new File(directory);

        File[] matchingFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lowerCaseName = name.toLowerCase();
                return matchingExtensions(extensions, lowerCaseName);
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with specified extensions in: " + dir.getAbsolutePath());
        }
    }

    private static boolean matchingExtensions(Set<String> extensions, String fileName) {
        String lowerCaseName = fileName.toLowerCase();
        return extensions.contains(lowerCaseName.substring(lowerCaseName.lastIndexOf(".") + 1));
    }
}
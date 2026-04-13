import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_21770_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");

        System.out.println("Searching in: " + rootDirectory.getAbsolutePath());

        String[] extensions = {"txt", "jpg", "jpeg", "png"};
        File[] foundFiles = rootDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if (name.endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (foundFiles != null) {
            Arrays.sort(foundFiles);
            for (File file : foundFiles) {
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found.");
        }
    }
}
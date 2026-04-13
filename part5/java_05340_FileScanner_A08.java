import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_05340_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory";
        String dirName = "sampleDir";

        File dir = new File(dirPath, dirName);
        if (dir.exists() && dir.isDirectory()) {
            File[] matchingFiles = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() && pathname.getName().equals(dirName);
                }
            });

            for (File file : matchingFiles) {
                System.out.println("Matching file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}
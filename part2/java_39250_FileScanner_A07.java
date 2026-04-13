import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_39250_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "test_dir";
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return new File(dir, name).isFile() && name.equals("AuthFailure.txt");
                }
            };

            File[] files = dir.listFiles(filter);
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                }
            } else {
                System.out.println("No files found with the name 'AuthFailure.txt' in the directory.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}
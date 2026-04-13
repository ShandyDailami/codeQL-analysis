import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_01824_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.isFile()) {
                        return pathname.getName().endsWith(".txt");
                    }
                    return false;
                }
            });

            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Invalid directory or directory does not exist.");
        }
    }
}
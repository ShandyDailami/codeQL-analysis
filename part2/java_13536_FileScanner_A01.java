import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_13536_FileScanner_A01 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        String[] files = rootDirectory.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true; // accept all files
            }
        });

        if (files != null) {
            for (String file : files) {
                File fileObject = new File(file);

                if (fileObject.isDirectory()) {
                    // this is a directory, so we'll recurse into it
                    System.out.println("Directory: " + fileObject.getAbsolutePath());
                    walkDirectory(fileObject);
                } else {
                    // this is a file
                    System.out.println("File: " + fileObject.getAbsolutePath());
                }
            }
        }
    }

    private static void walkDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // this is a directory, so we'll recurse into it
                    System.out.println("Directory: " + file.getAbsolutePath());
                    walkDirectory(file);
                } else {
                    // this is a file
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}
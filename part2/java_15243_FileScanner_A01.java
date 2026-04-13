import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_15243_FileScanner_A01 {

    public static void main(String[] args) {
        String directory = "/path/to/directory";  // replace with your directory
        String extension = "txt";  // replace with your file extension

        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith("." + extension);
                }
            });

            if (files != null) {
                Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);

                for (File file : files) {
                    printFileInfo(file);
                }
            } else {
                System.out.println("No files with extension " + extension + " in directory " + directory);
            }
        } else {
            System.out.println("Directory " + directory + " not found.");
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Last modified: " + file.lastModified());
    }
}
import java.io.File;
import java.io.FileFilter;

public class java_23692_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String extension = "txt"; // replace with your desired extension

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFilesWithExtension(directory, extension);
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }

    private static void listFilesWithExtension(File directory, String extension) {
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith("." + extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with extension " + extension + " found in directory " + directory.getAbsolutePath());
        }
    }
}
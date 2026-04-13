import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_28422_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // Using FileFilter for filtering files
        File[] textFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(".*\\.(txt|docx|pdf)$");
            }
        });

        // Using FilenameFilter for filtering directories
        File[] directories = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.isDirectory();
            }
        });

        // Printing out the files and directories
        System.out.println("Files:");
        for (File file : textFiles) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("Directories:");
        for (File dir : directories) {
            System.out.println(dir.getAbsolutePath());
        }
    }
}
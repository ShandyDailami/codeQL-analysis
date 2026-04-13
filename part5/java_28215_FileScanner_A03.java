import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_28215_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".txt";

        File directory = new File(directoryPath);

        // Using FileFilter
        File[] textFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(fileExtension);
            }
        });

        // Using FilenameFilter
        File[] textFiles2 = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(fileExtension);
            }
        });

        // Printing the files
        System.out.println("Text files in directory:");
        for (File file : textFiles) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("Text files in directory (using FilenameFilter):");
        for (File file : textFiles2) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
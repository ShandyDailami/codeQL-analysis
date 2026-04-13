import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_28457_FileScanner_A01 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        String fileExtension = ".txt";
        scanDirectory(rootDirectory, fileExtension);
    }

    private static void scanDirectory(File directory, String fileExtension) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(fileExtension);
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(SecuritySensitiveFileScanner::printFileDetails);
        }

        File[] subDirectories = directory.listFiles(File::directory);
        if (subDirectories != null) {
            Arrays.stream(subDirectories).forEach(SecuritySensitiveFileScanner::scanDirectory);
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("------------------------");
    }
}
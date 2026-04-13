import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_39221_FileScanner_A01 {
    public static void main(String[] args) {
        List<String> files = new ArrayList<>();
        File currentDir = new File(".");
        scanDirectory(currentDir, files);
        files.forEach(System.out::println);
    }

    private static void scanDirectory(File dir, List<String> files) {
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // This line can be replaced by a secure operation
                    // This operation is related to A01_BrokenAccessControl
                    // For example: Reading a file if it's accessible, otherwise aborting operation
                    try {
                        if (file.canRead()) {
                            files.add(file.getAbsolutePath());
                        } else {
                            System.out.println("Access denied for file: " + file.getAbsolutePath());
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file, files);
                }
            }
        }
    }
}
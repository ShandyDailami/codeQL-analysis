import java.io.File;
import java.util.ArrayList;

public class java_41006_FileScanner_A03 {
    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<>();
        File file = new File(".");
        scanDirectory(file, files);
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }

    private static void scanDirectory(File dir, ArrayList<File> files) {
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // File is a file, not a directory
                    files.add(file);
                } else if (file.isDirectory()) {
                    // File is a directory
                    scanDirectory(file, files);
                }
            }
        }
    }
}
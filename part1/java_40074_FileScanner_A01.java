import java.io.File;
import java.util.Arrays;

public class java_40074_FileScanner_A01 {

    public static void main(String[] args) {
        scanDirectory(".", ".");
    }

    public static void scanDirectory(String directoryPath, String prefix) {
        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles == null) return;

        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                scanDirectory(file.getAbsolutePath(), prefix + "/" + file.getName());
            } else {
                System.out.println(prefix + "/" + file.getName());
            }
        }
    }
}
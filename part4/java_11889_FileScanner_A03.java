import java.io.File;
import java.util.Arrays;

public class java_11889_FileScanner_A03 {

    public static void main(String[] args) {
        scanDirectory("./");
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        System.out.println("File Name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}
import java.io.File;
import java.util.Arrays;

public class java_23778_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("."); // Use current directory
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            Arrays.sort(listOfFiles);
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
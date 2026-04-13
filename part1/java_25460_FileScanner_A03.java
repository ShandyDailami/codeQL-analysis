import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_25460_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("."); // get current directory
        File[] listOfFiles = file.listFiles();

        if (listOfFiles != null) {
            Arrays.sort(listOfFiles, (file1, file2) -> file1.getName().compareTo(file2.getName()));

            for (File fileTemp : listOfFiles) {
                if (fileTemp.isFile()) {
                    System.out.println(fileTemp.getName());
                }
            }
        }
    }
}
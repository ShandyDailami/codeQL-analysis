import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_27462_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            Arrays.sort(list);
            for (String fileName : list) {
                File file = new File(fileName);
                System.out.println(file.getName());
            }
        }
    }
}
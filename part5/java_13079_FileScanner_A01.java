import java.io.File;
import java.util.Arrays;

public class java_13079_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");

        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles);
            for (File f : listFiles) {
                if (f.isDirectory()) {
                    System.out.println("DIRECTORY: " + f.getName());
                } else {
                    System.out.println("FILE: " + f.getName());
                }
            }
        }
    }
}
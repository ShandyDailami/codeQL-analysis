import java.io.File;
import java.util.Scanner;

public class java_28982_FileScanner_A03 {

    public static void main(String[] args) {
        File fileDir = new File("."); // get the current directory
        File[] foundFiles = fileDir.listFiles();

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}
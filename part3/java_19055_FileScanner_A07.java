import java.io.File;
import java.util.Scanner;

public class java_19055_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.isDirectory()) {
            System.out.println("Directory scanning " + file.getAbsolutePath());
            String[] list = file.list();

            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        } else {
            System.out.println(file.getAbsolutePath() + " is not a directory");
        }
    }
}
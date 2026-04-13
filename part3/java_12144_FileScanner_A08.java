import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class java_12144_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("."); // Points to the current directory
            if (file.exists()) {
                if (file.isDirectory()) {
                    System.out.println("Directory listing:");
                    FileScanner fs = file.listFiles();
                    Iterator<File> it = fs.iterator();

                    while (it.hasNext()) {
                        File f = it.next();
                        System.out.println(f.getName());
                    }
                } else {
                    System.out.println("Not a directory");
                }
            } else {
                System.out.println("Does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
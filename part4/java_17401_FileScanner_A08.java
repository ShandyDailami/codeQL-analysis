import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17401_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith(".") && !name.endsWith(".git"));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.isFile() && !file.getName().endsWith(".java")) {
                    System.out.println("Ignoring " + file.getName() + "...");
                }
            }
        }
    }
}
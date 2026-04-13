import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_27561_FileScanner_A03 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a directory as argument.");
            return;
        }
        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println("Provided argument is not a directory.");
            return;
        }
        String[] files = directory.list();
        if (files != null) {
            Arrays.sort(files);
            for (String file : files) {
                File fileObject = new File(directory, file);
                if (fileObject.isFile()) {
                    System.out.println(fileObject.getName());
                }
            }
        } else {
            System.out.println("Provided argument is not a directory.");
        }
    }
}
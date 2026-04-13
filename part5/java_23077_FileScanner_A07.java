import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_23077_FileScanner_A07 {
    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        File dir = new File(currentDir);

        if (args.length > 0) {
            dir = new File(args[0]);
        }

        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        if (!dir.isDirectory()) {
            System.out.println("Provided path is not a directory!");
            System.exit(1);
        }

        File[] listOfFiles = dir.listFiles();

        if (listOfFiles == null) {
            System.out.println("Unable to list directory contents!");
            System.exit(1);
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
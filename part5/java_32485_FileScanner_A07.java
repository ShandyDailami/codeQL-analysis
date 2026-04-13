import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32485_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");

        if (args.length == 0) {
            System.out.println("Please provide a directory as an argument.");
            return;
        }

        if (args[0].matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Invalid pattern for user input.");
            return;
        }

        directory = new File(args[0]);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory.");
            return;
        }

        String[] files = directory.list();

        if (files == null) {
            System.out.println("Unable to list files in the directory.");
            return;
        }

        for (String file : files) {
            File fileObj = new File(directory.getPath() + "/" + file);

            if (fileObj.setReadable(false)) {
                System.out.println("Permission error on file: " + fileObj.getPath());
            }
        }
    }
}
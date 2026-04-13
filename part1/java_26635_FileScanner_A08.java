import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26635_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String dirPath = input.nextLine();

        File directory = new File(dirPath);

        if (directory.isDirectory()) {
            System.out.println("Files in directory: " + directory.getPath());
            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(directory.getPath() + "/" + file);
                    if (fileObj.isFile() && fileObj.canRead()) {
                        System.out.println(fileObj.getName());
                    }
                }
            } else {
                System.out.println("No files in directory: " + directory.getPath());
            }
        } else {
            System.out.println(directory.getPath() + " is not a directory.");
        }
    }
}
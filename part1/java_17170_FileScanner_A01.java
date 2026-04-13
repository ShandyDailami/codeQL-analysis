import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17170_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = input.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The specified path does not exist or is not a directory.");
            return;
        }

        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("Unable to list files in the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                System.out.println("Path: " + file.getAbsolutePath());
                System.out.println();
            }
        }

        input.close();
    }
}
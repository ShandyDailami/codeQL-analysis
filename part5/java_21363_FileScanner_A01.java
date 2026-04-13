import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21363_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                listFiles(directory, "");
            } else {
                System.out.println("'" + directoryPath + "' is not a directory.");
            }
        } else {
            System.out.println("'" + directoryPath + "' does not exist.");
        }
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    listFiles(file, indent + "  ");
                } else {
                    System.out.println(indent + "File: " + file.getName());
                }
            }
        }
    }
}
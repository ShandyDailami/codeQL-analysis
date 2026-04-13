import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28451_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists() && file.isDirectory()) {
            System.out.println("Scanning the directory for file(s):");
            File[] listOfFiles = file.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt")) {
                    System.out.println("File found: " + listOfFiles[i].getName());
                }
            }
        } else {
            System.out.println("Invalid directory or not a directory.");
        }
    }
}
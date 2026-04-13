import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_26950_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // a. Here's a creative way to get a file path from user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                // c. Don't use external frameworks
                // d. Make sure the program is syntactically correct Java code
                // e. Here's a code snippet that starts with 'java'
                File[] listOfFiles = directory.listFiles();
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        // f. Remove the comment
                        System.out.println(listOfFiles[i].getName());
                    }
                }
            } else {
                System.out.println("The provided path is not a directory.");
            }
        } else {
            System.out.println("The provided path does not exist.");
        }

        scanner.close();
    }
}
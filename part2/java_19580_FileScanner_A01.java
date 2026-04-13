import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19580_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file or directory:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                if (!file.canRead()) {
                    System.out.println("Access to the file is restricted. Please enter a valid path.");
                } else {
                    System.out.println("File access granted.");
                    // perform security-sensitive operation
                    System.out.println("Performing security-sensitive operation...");
                }
            } else if (file.isDirectory()) {
                if (!file.canRead()) {
                    System.out.println("Access to the directory is restricted. Please enter a valid path.");
                } else {
                    System.out.println("Directory access granted.");
                    // perform security-sensitive operation
                    System.out.println("Performing security-sensitive operation...");
                }
            } else {
                System.out.println("Entered path is not a file or directory.");
            }
        } else {
            System.out.println("The file or directory does not exist.");
        }
    }
}
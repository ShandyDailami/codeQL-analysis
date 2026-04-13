import java.io.File;
import java.util.Scanner;

public class java_17951_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new File instance that represents the current directory
        File currentDirectory = new File(".");

        // Create a new Scanner instance
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory name
        System.out.println("Enter a directory name:");
        String directoryName = scanner.nextLine();

        // Create a new File instance that represents the user's chosen directory
        File directory = new File(directoryName);

        // Print out the names of the files in the directory
        if (directory.isDirectory()) {
            String[] files = directory.list();
            for (int i = 0; i < files.length; i++) {
                File file = new File(directoryName + "/" + files[i]);
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("The provided path does not represent a directory.");
        }
    }
}
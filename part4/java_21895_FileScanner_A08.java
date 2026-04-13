import java.io.File;
import java.util.Scanner;

public class java_21895_FileScanner_A08 {

    public static void main(String[] args) {

        // Request user input
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        // Create a File object and initialize it with the directory path
        File directory = new File(directoryPath);

        // Create a File object for the file and set its name
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // Print out the names of the files
        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No .txt files in the directory.");
        }
    }
}
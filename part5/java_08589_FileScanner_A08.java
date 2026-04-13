import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_08589_FileScanner_A08 {

    public static void main(String[] args) {

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory
        System.out.println("Enter a directory:");
        String directoryPath = scanner.nextLine();

        // Check if the given path exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // List all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        }
    }
}
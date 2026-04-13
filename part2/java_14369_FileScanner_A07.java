import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_14369_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory name: ");
        String directoryName = scanner.nextLine();

        File directory = new File(directoryName);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (directory.isFile()) {
            System.out.println("You have entered a file not a directory.");
            return;
        }

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles == null) {
            System.out.println("No .txt files found in directory.");
            return;
        }

        for (File file : txtFiles) {
            System.out.println("Found .txt file: " + file.getName());
        }
    }
}
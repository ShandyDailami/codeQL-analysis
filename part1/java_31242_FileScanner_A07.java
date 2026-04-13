import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_31242_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        System.out.println("Files starting with 'A': ");
        File[] files = directory.listFiles((dir, name) -> name.startsWith("A"));

        if (files == null) {
            System.out.println("No files found.");
            return;
        }

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
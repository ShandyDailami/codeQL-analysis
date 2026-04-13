import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26647_FileScanner_A03 {

    public static void main(String[] args) {
        System.out.println("Enter a directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Could not open file: " + file.getName());
                }
            }
        }
    }
}
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_31203_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        readFile(file);
                    }
                }
            } else {
                System.out.println("Directory is empty or does not exist");
            }
        } else {
            System.out.println("Provided path is not a valid directory");
        }
    }

    private static void readFile(File file) {
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}